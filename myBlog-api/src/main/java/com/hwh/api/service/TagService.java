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

    /**
     * 寻找热门标签
     * @param size 热门标签数量
     * @return 热门标签列表
     * */
    List<TagVo> getHotTag(int size);

    /**
     * 获得所有标签
     * @return 所有标签集合
     * */
    List<TagVo> findAll();

    /**
     * 获得所有标签细节
     * @return 所有标签集合细节
     * */
    List<TagVo> findAllDetail();

    /**
     * 获得标签细节
     * @param id 标签id
     * @return 标签集合细节
     * */
    TagVo findDetail(Long id);
}
