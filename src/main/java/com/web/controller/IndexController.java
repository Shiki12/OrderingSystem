package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/index" )

public class IndexController {

    @RequestMapping("/index1")
    @ResponseBody
    public void getdinedata(@RequestParam("dinename")String dinename){
        System.out.println(dinename);
    }

    @RequestMapping("/test")
    public String test(){
        return "cus/index";
    }
}
