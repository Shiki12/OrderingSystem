package com.web.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.entity.Product;
import com.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/backstage")
public class fController {

    @Autowired
    ProductService productService;

    @RequestMapping("/empty")
    //得到所有的数据
    public String getAll(Model model,
                         @RequestParam(defaultValue = "1",value = "pageNum")int pageNum) {
        //设置页面大小
        PageHelper.startPage(pageNum,10);
        List<Product> list = productService.getAll();
        //pageHelper 包装之后的代码
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        model.addAttribute("pageInfo",pageInfo);
        System.out.println(pageInfo);
        return "xf/empty";
    }

    @RequestMapping("/chart")
    public String toxfchart(){
        return "xf/chart";
    }

    @RequestMapping("/index")
    public String toxfindex(){
        return "xf/index";
    }

    @RequestMapping("/panel")
    public String toxfpanel(){
        return "xf/panel";
    }

    @RequestMapping("/elements")
    public String toxfelements(){
        return "xf/elements";
    }

    @RequestMapping("/form")
    public String toxfform(){
        return "xf/form";
    }

    @RequestMapping("/table")
    public String toxftable(){
        return "xf/table";
    }

    @RequestMapping("/test")
    public String totest(){
        return "xf/test";
    }
}
