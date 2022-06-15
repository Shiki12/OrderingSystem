package com.web.controller;

import com.web.dao.CategoryDao;
import com.web.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;

@RequestMapping("/category")
    public String getall(Model model){

        List<Category> categories = categoryDao.queryList();

    for (Category category : categories) {
        System.out.println(category);
    }
        model.addAttribute("list",categories);

        return "admin/index";
    }



}

