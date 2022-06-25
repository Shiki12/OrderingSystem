package com.web.controller;


import com.web.entity.Alipay;
import com.web.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/alipay")
public class AlipayController {

   AlipayService alipayService;
    @Autowired
    public void setAlipayService(AlipayService alipayService) {
        this.alipayService = alipayService;
    }


    @GetMapping("/")
    public String index(){
        return "pay/index";
    }

    @PostMapping("/create")
    public String create(Alipay alipay, Model model){
        String pay = alipayService.pay(alipay);
        model.addAttribute("form", pay);
        return "pay/pay";
    }


    @PostMapping("/notify")
    @ResponseBody
    public void notifyUrl(String trade_no, String total_amount, String trade_status){
        System.err.println("支付宝订单编号：" + trade_no + ", 订单金额： " + total_amount + ",订单状态：" + trade_status);
    }

    @GetMapping("/return")
    public String returnNoticel(){
        return "cus/index";
    }
}
