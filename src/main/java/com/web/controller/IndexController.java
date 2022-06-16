package com.shiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
