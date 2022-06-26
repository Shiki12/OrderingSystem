package com.web.controller;

import com.web.dao.CategoryDao;
import com.web.entity.Category;
import com.web.wechat.dataUtil.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;

    @RequestMapping("/getList")
    @ResponseBody
    public ResponseData getAll(Model model){

        List<Category> categories = categoryDao.queryList();

         if (categories.isEmpty()){
             return new ResponseData(0,"响应失败");
         }
         else {
             return  new ResponseData(1,"响应成功",categories);
         }

    }

}

