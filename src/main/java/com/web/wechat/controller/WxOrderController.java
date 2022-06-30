package com.web.wechat.controller;

import com.web.wechat.dataUtil.ResponseData;
import com.web.wechat.service.WxOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/wx_order")
@RestController
public class WxOrderController {
    @Resource
    private WxOrderService wxOrderService;

    @RequestMapping("/getOrderByToken")
    public ResponseData getOrderByToken(String token){
        return wxOrderService.getOrderByToken(token);
    }

    @RequestMapping("/addOrder")
    public ResponseData addOrder(int pid,String token){
        return wxOrderService.addOrder(pid,1,token);}

}
