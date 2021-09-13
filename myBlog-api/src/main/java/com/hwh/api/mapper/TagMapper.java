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
}
