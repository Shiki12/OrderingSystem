package com.web.controller;

import com.web.dao.AdministratorDao;
import com.web.entity.Administrator;
import com.web.entity.Customer;
import com.web.service.CustomerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/login")
@Controller
public class LoginController {
    @Autowired
    AdministratorDao administratorDao;

    @Autowired
    CustomerService customerService;

    @RequestMapping("/") //
    public String toLogin(){
        return "admin/login";
    }


    @RequestMapping("") //
    public String toUserLogin(){
        return "cus/login";
    }

    @RequestMapping ("/admin")  //管理员登录功能
    @ResponseBody
    public String login(
            @RequestParam("username")String username,
            @RequestParam("password")String password, Model model, HttpSession session){

        //得到subject对象
        Subject subject = SecurityUtils.getSubject();
        //得到token
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            //执行登录完了之后存放session
            session.setAttribute("loginUser",username);

            Administrator administrator = administratorDao.selectByName(username);
            String lastLoginTime="";
            if (administrator!= null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //得到上次登陆的时间
                Date time = administrator.getLasttime();
                //上次时间
                lastLoginTime = sdf.format(time);
                //当前时间
                String format = sdf.format(new Date());
                //string转date  不处理时间格式会不理想
                ParsePosition pos = new ParsePosition(0);
                Date strtodate = sdf.parse(format, pos);
                administrator.setLasttime(strtodate);
                administratorDao.update(administrator);
                return "admin/index";
            }

        }catch (Exception e){
            model.addAttribute("msg","程序异常");
            return "";
        };
        return "";

    }
    @RequestMapping("/customer")
    @ResponseBody
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,HttpSession session,Model model){

        Customer customer = customerService.getByName(username);
        if (customer!=null){
            if (password.equals(customer.getPassword())){
              session.setAttribute("customer",customer);
              model.addAttribute("msg","登录成功");
              return "success";
            }
            else {
                model.addAttribute("msg","账号或密码错误");
                return "cus/login";
            }
        }
        else {
            return "cus/login";
        }

    }


}
