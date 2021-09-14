package com.hwh.api.service.impl;

import com.hwh.api.mapper.CategoryMapper;
import com.hwh.api.service.CategoryService;
import com.hwh.common.domain.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HwH
 * @date 2021/9/14 18:14
 * @description 类别实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public Category findCategoryById(Long id) {
        return categoryMapper.findCategoryById(id);
    }
}
