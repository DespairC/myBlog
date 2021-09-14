package com.hwh.api.service;

import com.hwh.common.domain.dto.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/14 18:14
 * @description 类别服务
 */
public interface CategoryService {

    /**
     * 根据类别id查询类别信息
     * @param id 类别id
     * @return 类别信息
     */
    Category findCategoryById(Long id);
}
