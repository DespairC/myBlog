package com.hwh.api.mapper;

import com.hwh.common.domain.dto.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/14 18:14
 * @description
 */
@Repository
public interface CategoryMapper {

    /**
     * 根据类别id查询类别信息
     * @param id 类别id
     * @return 类别信息
     */
    Category findCategoryById(@Param("id") Long id);

}
