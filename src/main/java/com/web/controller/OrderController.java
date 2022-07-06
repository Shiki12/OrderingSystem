package com.web.controller;

import com.web.entity.Alipay;
import com.web.entity.Customer;
import com.web.entity.Order;
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
    @ResponseBody
    public ResponseData addOrderShop(OrderItem orderItem){
            int i = orderService.addOrderShop(orderItem);
            if (i != 0){
                return  new ResponseData(1,"添加成功");
            }
            else {
                return  new ResponseData(0,"添加失败");
            }

    }

    /**
     *
     * @param id  查找用户的购物车
     * @return
     */

     @RequestMapping("/getOrderShop")
     @ResponseBody
    public ResponseData  getOrderShop(int id){
         List<Order> orderShop = orderService.getOrderShop(id);
         if (orderShop!= null){
             return  new ResponseData(1,"请求成功",orderShop);
         }
         else {
             return  new ResponseData(0,"添加失败");
         }
     }


    /**
     *  购物车下单
     * @param id
     * @return
     */
    @RequestMapping("/placeOrderShop")
    public String  placeOrderShop(int id,String address,RedirectAttributes re){

        Alipay alipay = orderService.placeOrderShop(id,address);

        re.addFlashAttribute("alipay",alipay);
        return "redirect:/alipay/create";
    }
}
