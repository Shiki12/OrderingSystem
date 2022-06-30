package com.web.controller;

import com.web.dao.ProductDao;
import com.web.entity.Product;
import com.web.wechat.dataUtil.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *  用来做一些数据统计
 */
@Controller
@RequestMapping("/echarts")
public class EchartsController {

    @Autowired
    ProductDao productDao;
    @RequestMapping("/index")
    public String toIndex(){
        return "echarts/index";
    }

    @RequestMapping("/getLastMost")
    @ResponseBody
    public ResponseData getLastMost(){

        List<Product> list = productDao.getLastMost();

        return  new ResponseData(1,"请求成功",list);
    }




}
