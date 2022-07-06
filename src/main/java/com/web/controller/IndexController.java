package com.web.controller;

import com.web.service.ProductService;
import com.web.wechat.dataUtil.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/index" )
public class IndexController {

    @Autowired
    ProductService productService;

    @RequestMapping("/search")
    @ResponseBody
    public ResponseData getdinedata(@RequestParam("dinename")String key){

        try {
            if (productService.fuzzyQuery(key)!= null){
                return  new ResponseData(1,"请求成功",productService.fuzzyQuery(key));
            }
            else {
                return new ResponseData(0,"不存在该类商品");
            }

        }catch (Exception e){
            return new ResponseData(0,"网络错误");
        }

    }

    @RequestMapping("/index")
    public String tocusindex(){
        return  "cus/index";
    }

    @RequestMapping("/menu")
    public String tocusmenu(){
        return "cus/menu";
    }
    @RequestMapping("/about")
    public String tocusabout(){
        return "cus/about";
    }
    @RequestMapping("/cuslogin")
    public String tocuslogin(){
        return "cus/login";
    }

    @RequestMapping("commod")
    public String getcommod(){
        return "评论";
    }

    @RequestMapping("/shopper")
    public String toorder(){
        return "cus/shopper";
    }

    @RequestMapping("/order")
    public String toorderone(){
        return "cus/order";
    }

}
