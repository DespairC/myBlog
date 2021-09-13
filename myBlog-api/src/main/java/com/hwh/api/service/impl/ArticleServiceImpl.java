package com.hwh.api.service.impl;

import com.hwh.api.mapper.ArticleMapper;
import com.hwh.api.service.ArticleService;
import com.hwh.api.service.SysUserService;
import com.hwh.api.service.TagService;
import com.hwh.common.domain.dto.Article;
import com.hwh.common.domain.dto.SysUser;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.vo.Archives;
import com.hwh.common.domain.vo.ArticleVo;
import com.hwh.common.domain.vo.PageParam;
import com.hwh.common.domain.vo.TagVo;
import com.hwh.common.exception.ErrorException;
import com.hwh.common.util.Result;
import com.hwh.common.util.TimeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HwH
 * @date 2021/9/12 9:56
 * @description 文章实现类
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleMapper articleMapper;
    private SysUserService sysUserService;
    private TagService tagService;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper, SysUserService sysUserService, TagService tagService) {
        this.articleMapper = articleMapper;
        this.sysUserService = sysUserService;
        this.tagService = tagService;
    }

    /**
     * 组装单个展示类
     * */
    private ArticleVo copy(Article article,boolean isAuthor,boolean isBody,boolean isTags){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        if (isAuthor) {
            SysUser sysUser = sysUserService.getUserById(article.getAuthorId());
            articleVo.setAuthor(sysUser.getNickname());
        }
        articleVo.setCreateDate(TimeUtil.longToDate(article.getCreateDate()));
        if (isTags){
            List<TagVo> tags = tagService.getTagByArticleId(article.getId());
            articleVo.setTags(tags);
        }
        return articleVo;
    }

    /**
     * 组装集合展示类
     * */
    private List<ArticleVo> copyList(List<Article> records,boolean isAuthor,boolean isBody,boolean isTags){
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article article : records) {
            articleVoList.add(copy(article, isAuthor, isBody, isTags));
        }
        return articleVoList;
    }


    @Override
    public List<ArticleVo> getArticle(PageParam pageParam) {
        if(pageParam == null){
            throw new ErrorException(CodeEnum.NULL_PARAM);
        }
        return copyList(articleMapper.getArticle(pageParam.getPage(), pageParam.getPageSize()),
                true , false, true);
    }

    @Override
    public List<ArticleVo> getHotArticle(int size) {
        return copyList(articleMapper.getHotArticle(size),false, false, false);
    }

    @Override
    public List<ArticleVo> getNewArticle(int size) {
        return copyList(articleMapper.getNewArticle(size), false, false, false);
    }

    @Override
    public List<Archives> getListArchives() {
        return articleMapper.getListArchives();
    }
}
