package com.shiki.controller;

import com.shiki.dao.AdministratorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class LoginController {
    @Autowired
    AdministratorDao administratorDao;


    @RequestMapping("/admin")
    public String login(
            @RequestParam("username")String name,
            @RequestParam("password")String password){



        return "index";
    }


}
