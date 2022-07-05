package com.web.controller;

import com.web.dao.OrderDao;
import com.web.entity.Customer;
import com.web.entity.Order;
import com.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 后台管理订单  Controller
 */
@Controller
@RequestMapping("/adminOrder")
public class AdminOrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDao orderDao;


    //得到某一人的所有订单
    @RequestMapping("/getOnePerson")
    @ResponseBody
    public String getCustomerOrder(Customer customer, Model model){

        List<Order> orders = orderService.getCustomerOrder(customer);
        model.addAttribute("orders",orders);
        return "admin/orderIndex";
    }


    @RequestMapping("/index") //
    public String getAll(Model model){

        List<Order> orders = orderDao.getAllOrder();
        model.addAttribute("orders",orders);
        return "admin/orderIndex";
    }




}
