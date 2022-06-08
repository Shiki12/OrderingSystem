package com.shiki.controller;

import com.shiki.dao.CategoryDao;
import com.shiki.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * (Category)表控制层
 *
 * @author makejava
 * @since 2022-06-07 21:13:40
 */
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

        return "index";
    }



}

