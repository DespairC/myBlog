package com.hwh.api.service;

import com.hwh.common.domain.enums.CodeEnum;
import com.hwh.common.domain.vo.CategoryVo;
import com.hwh.common.util.Result;

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
    CategoryVo findCategoryById(Long id);

    /**
     * 获取所有类别
     * @return 所有类别列表
     * */
    List<CategoryVo> findAll();

    /**
     * 获取所有类别细节
     * @return 所有类别细节列表
     * */
    List<CategoryVo> findAllDetail();

    /**
     * 获取类别细节
     * @param id 类别id
     * @return 类别细节集合
     * */
    CategoryVo findDetail(Long id);
}
