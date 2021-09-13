package com.hwh.api.service;

import com.hwh.common.domain.vo.TagVo;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/12 23:26
 * @description 标签服务
 */
public interface TagService {

    /**
     * 根据文章id获取标签
     * @param articleId 文章id
     * @return 标签列表
     * */
    List<TagVo> getTagByArticleId(Long articleId);
}
