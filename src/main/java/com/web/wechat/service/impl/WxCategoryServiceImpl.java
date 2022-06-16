package com.web.wechat.service.impl;

import com.web.dao.CategoryDao;
import com.web.entity.Category;
import com.web.wechat.service.WxCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxCategoryServiceImpl implements WxCategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<String> getAll() {
        categoryDao.queryList();
        return null;
    }
}
