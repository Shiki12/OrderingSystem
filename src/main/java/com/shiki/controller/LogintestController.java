package com.shiki.controller;


import com.shiki.dao.AdministratorDao;
import com.shiki.entity.Administrator;
import com.shiki.entity.Customer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/logincus")
@Controller
public class LogintestController {

    Customer customer;
    @RequestMapping ("/cus")
    public String login1(){
        return "admin/login";
    }
}
