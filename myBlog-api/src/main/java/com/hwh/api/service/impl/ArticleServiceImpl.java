package com.hwh.api.service.impl;

import com.hwh.api.mapper.ArticleBodyMapper;
import com.hwh.api.mapper.ArticleMapper;
import com.hwh.api.mapper.ArticleTagMapper;
import com.hwh.api.service.*;
import com.hwh.common.domain.dto.Article;
import com.hwh.common.domain.dto.ArticleBody;
import com.hwh.common.domain.dto.ArticleTag;
import com.hwh.common.domain.dto.SysUser;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.vo.Archives;
import com.hwh.common.domain.vo.ArticleVo;
import com.hwh.common.domain.vo.TagVo;
import com.hwh.common.domain.vo.param.ArticleParam;
import com.hwh.common.domain.vo.param.PageParam;
import com.hwh.common.exception.ErrorException;
import com.hwh.common.util.TimeUtil;
import com.hwh.common.util.UserThreadLocal;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HwH
 * @date 2021/9/12 9:56
 * @description 文章实现类
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleMapper articleMapper;
    private final SysUserService sysUserService;
    private final TagService tagService;
    private final CategoryService categoryService;
    private final ThreadService threadService;
    private final ArticleBodyMapper articleBodyMapper;
    private final ArticleTagMapper articleTagMapper;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper, SysUserService sysUserService
            , TagService tagService, CategoryService categoryService
            ,ThreadService threadService, ArticleBodyMapper articleBodyMapper
            ,ArticleTagMapper articleTagMapper) {
        this.articleMapper = articleMapper;
        this.sysUserService = sysUserService;
        this.tagService = tagService;
        this.categoryService = categoryService;
        this.threadService = threadService;
        this.articleBodyMapper = articleBodyMapper;
        this.articleTagMapper = articleTagMapper;
    }

    /**
     * 组装单个展示类
     * */
    private ArticleVo copy(Article article,boolean isAuthor,boolean isBody,boolean isTags, boolean idCategory){
        if(article == null){
            return null;
        }
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        //作者
        if (isAuthor) {
            SysUser sysUser = sysUserService.getUserById(article.getAuthorId());
            articleVo.setAuthor(sysUser.getNickname());
        }
        //内容
        if (isBody){
            articleVo.setBody(articleBodyMapper.getArticleBodyById(article.getId()));
        }
        //创建日期
        articleVo.setCreateDate(TimeUtil.longToDate(article.getCreateDate()));
        //标签
        if (isTags){
            articleVo.setTags(tagService.getTagByArticleId(article.getId()));
        }
        //类别
        if (idCategory){
            articleVo.setCategory(categoryService.findCategoryById(article.getCategoryId()));
        }
        return articleVo;
    }

    /**
     * 组装集合展示类
     * */
    private List<ArticleVo> copyList(List<Article> records,boolean isAuthor,boolean isBody,boolean isTags, boolean idCategory){
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article article : records) {
            articleVoList.add(copy(article, isAuthor, isBody, isTags, idCategory));
        }
        return articleVoList;
    }


    @Override
    public List<ArticleVo> getArticle(PageParam pageParam) {
        if(pageParam == null){
            throw new ErrorException(CodeEnum.NULL_PARAM);
        }
        pageParam.setPage(pageParam.getPage() - 1);
        return copyList(articleMapper.getArticle(pageParam),
                true , false, true, true);
    }

    @Override
    public List<ArticleVo> getHotArticle(int size) {
        return copyList(articleMapper.getHotArticle(size),false, false, false, false);
    }

    @Override
    public List<ArticleVo> getNewArticle(int size) {
        return copyList(articleMapper.getNewArticle(size), false, false, false, false);
    }

    @Override
    public List<Archives> getListArchives() {
        return articleMapper.getListArchives();
    }

    @Override
    public ArticleVo findArticleById(Long id) {
        Article article = articleMapper.getArticleById(id);
        threadService.updateViewCount(articleMapper, article);
        return copy(article, true, true, true, true);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ArticleVo publishArticle(ArticleParam articleParam) {

        //获取本地用户信息
        SysUser sysUser = UserThreadLocal.get();

        Article article = new Article();
        article.setAuthorId(sysUser.getId());
        article.setTitle(articleParam.getTitle());
        article.setViewCounts(0);
        article.setCreateDate(System.currentTimeMillis());
        article.setWeight(0);
        article.setCommentCounts(0);
        article.setSummary(articleParam.getSummary());
        article.setCategoryId(articleParam.getCategory().getId());

        //插入文章
        articleMapper.insert(article);

        //插入标签
        List<TagVo> tagVoList = articleParam.getTags();
        if(tagVoList != null){
            for (TagVo tagVo : tagVoList) {
                ArticleTag articleTag = new ArticleTag();
                articleTag.setArticleId(article.getId());
                articleTag.setTagId(tagVo.getId());
                articleTagMapper.insert(articleTag);
            }
        }

        //插入文章主体内容
        ArticleBody articleBody = new ArticleBody();
        BeanUtils.copyProperties(articleParam.getBody(),articleBody);
        articleBody.setArticleId(article.getId());
        articleBodyMapper.insert(articleBody);


        //更新内容id
        article.setBodyId(articleBody.getId());
        articleMapper.update(article);

        //返回文章id
        ArticleVo articleVo = new ArticleVo();
        articleVo.setId(article.getId());

        return articleVo;
    }
}
