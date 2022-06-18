package com.web.controller;

import com.web.dao.CategoryDao;
import com.web.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;

@RequestMapping("/category")
@ResponseBody
    public String getAll(Model model){

        List<Category> categories = categoryDao.queryList();

    for (Category category : categories) {
        System.out.println(category);
    }
        model.addAttribute("list",categories);

        return "admin/index";
    }

}

