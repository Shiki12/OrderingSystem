package com.web.controller;


import com.web.entity.Customer;
import com.web.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @RequestMapping("/getAll")

    public List getAll(Model model){
        List<Customer> customers = customerService.getAll();

        model.addAttribute("customers",customers);

        return customers;
    }

    @RequestMapping("/add")
    public String addCustomer(Customer customer){

        log.info("customer={}",customer);


        if ( customerService.addCustomer(customer)>0){
            return "ok";
        }
        else {

            return "false";
        }
        //返回管理的页面

    }

    @RequestMapping("/delete/{id}")
   public String delete(@PathVariable("id") int id){

        log.info("删除的id是={}",id);

        if (customerService.deleteById(id)>0){
            return "ok";
        }

        return "false"; //返回视图

    }

    @RequestMapping("/update")
    public String update(Customer customer){
        log.info("需要更新的用户是={}",customer);

        if (customerService.update(customer)>0){
            return "更新成功";
        }


        return "shibai";//返回新视图
    }
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") int id,Model model){



        if (customerService.getById(id)!=null){
            return "ok";
        }
        //model.addAttribute("customer",customer);

        return "false";
    }







}
