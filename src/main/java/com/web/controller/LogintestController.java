package com.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/logincus")
@Controller
public class LogintestController {

    @RequestMapping ("/cus")
    public String login1(){
        return "cus/login";
    }
}
