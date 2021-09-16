package com.hwh.api.service.impl;

import com.hwh.api.mapper.CategoryMapper;
import com.hwh.api.service.CategoryService;
import com.hwh.common.domain.dto.Category;
import com.hwh.common.domain.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    private CategoryVo copy(Category category){
        if(category == null){
            return null;
        }
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }

    private List<CategoryVo> copyList(List<Category> categoryList){
        List<CategoryVo> list = new ArrayList<>();
        for (Category category : categoryList) {
            list.add(copy(category));
        }
        return list;
    }

    @Override
    public CategoryVo findCategoryById(Long id) {
        return copy(categoryMapper.findCategoryById(id));
    }

    @Override
    public List<CategoryVo> findAll() {
        return copyList(categoryMapper.findAll());
    }

    @Override
    public List<CategoryVo> findAllDetail() {
        return copyList(categoryMapper.selectList());
    }

    @Override
    public CategoryVo findDetail(Long id) {
        return copy(categoryMapper.findCategoryById(id));
    }
}
