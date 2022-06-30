package com.web.controller;


import com.web.entity.Customer;
import com.web.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @RequestMapping("/getAll")

    public String getAll(Model model){
        List<Customer> customers = customerService.getAll();

        model.addAttribute("customers",customers);

        return "admin/cusIndex";
    }

    @RequestMapping("/add")
    public String addCustomer(Customer customer){
        log.info("customer={}",customer);

        if (customerService.addCustomer(customer)>0){
            return "admin/cusIndex";
        }
        else {
            return "admin/404";
        }
        //返回管理的页面
    }

    @RequestMapping("/delete/{id}")
   public String delete(@PathVariable("id") int id){

        log.info("删除的id是={}",id);

        if (customerService.deleteById(id)>0){
            return "admin/cusIndex";
        }
        return "admin/404"; //返回视图

    }

    @RequestMapping("/update")
    public String update(Customer customer){
        log.info("需要更新的用户是={}",customer);

        if (customerService.update(customer)>0){
            return "admin/cusIndex";
        }


        return "admin/404";//返回新视图
    }
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") int id,Model model){
        Customer customer = customerService.getById(id);
        if (customer!=null){
            model.addAttribute("customer",customer);
            return "admin/cusIndex";
        }
        model.addAttribute("msg","数据请求错误");
        return "admin/404";
    }







}
