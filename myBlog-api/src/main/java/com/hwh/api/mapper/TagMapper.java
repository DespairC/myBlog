package com.hwh.api.mapper;

import com.hwh.common.domain.dto.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/12 14:39
 * @description 标签mapper
 */
@Repository
public interface TagMapper {

    /**
     * 根据文章id获取标签
     * @param articleId 文章id
     * @return 标签列表
     * */
    List<Tag> getTagByArticleId(@Param("articleId") Long articleId);

    /**
     * 根据标签id列表获取标签
     * @param tagIds 文章id列表
     * @return 标签列表
     * */
    List<Tag> getTagByTagIds(@Param("tagIds") List<Long> tagIds);

    /**
     * 寻找热门标签
     * @param size 热门标签数量
     * @return 热门标签列表
     * */
    List<Long> findHostTagIds(@Param("size") int size);

    /**
     * 获得所有标签
     * @return 所有标签集合
     * */
    List<Tag> findAll();

}
