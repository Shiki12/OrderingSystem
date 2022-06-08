package com.shiki.controller;

import com.shiki.dao.AdministratorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/login")
@Controller
public class LoginController {
    @Autowired
    AdministratorDao administratorDao;

    @RequestMapping("")
    public String toLogin(){
        return "admin/login";
    }

    @RequestMapping("/admin")
    public String login(
            @RequestParam("username")String username,
            @RequestParam("password")String password){
        System.out.println(username);
        System.out.println(password);

        return "admin/index";
    }


}
