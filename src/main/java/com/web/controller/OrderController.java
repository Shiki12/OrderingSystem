package com.web.controller;

import com.web.entity.Alipay;
import com.web.entity.Customer;
import com.web.entity.po.OrderItem;
import com.web.service.OrderService;
import com.web.wechat.dataUtil.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;


    @RequestMapping("/get")
    @ResponseBody
    public List getCustomerOrder(Customer customer){

        orderService.getCustomerOrder(customer);
        return orderService.getCustomerOrder(customer);

    }
    @RequestMapping("/placeOrder") //下单
    public String placeOrder(OrderItem orderItem, RedirectAttributes re){

        Alipay alipay = orderService.addBoth(orderItem);

        System.out.println(orderItem);
        re.addFlashAttribute("alipay",alipay);
        return "redirect:/alipay/create";
    }

    /*
     添加购物车
     */
    @RequestMapping("/addOrderShop")
    public ResponseData addOrderShop(OrderItem orderItem){
            int i = orderService.addOrderShop(orderItem);
            if (i != 0){
                return  new ResponseData(1,"添加成功");
            }
            else {
                return  new ResponseData(0,"添加失败");
            }

    }


     @RequestMapping("/getOrderShop")
    public ResponseData  getOrderShop(int id){



     }



}
