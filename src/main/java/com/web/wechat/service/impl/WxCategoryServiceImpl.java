package com.web.wechat.service.impl;

import com.web.dao.CategoryDao;
import com.web.entity.Category;
import com.web.wechat.service.WxCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WxCategoryServiceImpl implements WxCategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<String> getAll() {
        //wx端获取商品分类
        List<Category> categoryList = categoryDao.queryList();
        List<String> categories = categoryList.stream().map(Category::getName).collect(Collectors.toList());
        System.out.println(categories);
        return categories;
    }
}
