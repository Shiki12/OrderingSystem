package com.web.controller;

import com.web.dao.CategoryDao;
import com.web.dao.ProductDao;
import com.web.entity.Category;
import com.web.entity.Product;
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

    @Autowired
    ProductDao productDao;

    @RequestMapping("/getList")
    @ResponseBody //得到所有的菜品
    public ResponseData getAll(Model model){

        List<Category> categories = categoryDao.queryList();

         if (categories.isEmpty()){
             return new ResponseData(0,"响应失败");
         }
         else {
             return  new ResponseData(1,"响应成功",categories);
         }

    }
    @RequestMapping("/getOneType")
    @ResponseBody  //得到某一种的食物
    public ResponseData getOneType(int id){

        List<Product> list = productDao.getOneType(id);
        if (list.isEmpty()){
            return new ResponseData(0,"响应失败");
        }
        else{
            return  new ResponseData(1,"响应成功",list);
        }
    }

    @RequestMapping("/getAllPro")
    @ResponseBody  //得到所有的商品 直接返回给前端
    public ResponseData getAllPro(){

        List<Product> list = productDao.getAll();

        if (list.isEmpty()){
            return new ResponseData(0,"响应失败");
        }
        else{
            return  new ResponseData(1,"响应成功",list);
        }
    }


}

