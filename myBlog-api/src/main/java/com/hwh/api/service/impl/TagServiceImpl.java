package com.hwh.api.service.impl;

import com.hwh.api.mapper.TagMapper;
import com.hwh.api.service.TagService;
import com.hwh.common.domain.dto.Tag;
import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.vo.TagVo;
import com.hwh.common.exception.ErrorException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author HwH
 * @date 2021/9/12 23:26
 * @description 标签服务实现类
 */
@Service
public class TagServiceImpl implements TagService {
    private TagMapper tagMapper;

    @Autowired
    public TagServiceImpl(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    private TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag, tagVo);
        return tagVo;
    }

    private List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }

    @Override
    public List<TagVo> getTagByArticleId(Long articleId) {
        if(articleId == null){
            throw new ErrorException(CodeEnum.NULL_PARAM);
        }
        return copyList(tagMapper.getTagByArticleId(articleId));
    }

    @Override
    public List<TagVo> getHotTag(int size) {
        List<Long> hotIds = tagMapper.findHostTagIds(size);
        if(CollectionUtils.isEmpty(hotIds)){
            return Collections.EMPTY_LIST;
        }

        return copyList(tagMapper.getTagByTagIds(hotIds));
    }

}
