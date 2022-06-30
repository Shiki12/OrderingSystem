package com.web.wechat.controller;

import com.web.wechat.dataUtil.ResponseData;
import com.web.wechat.service.WxOrderService;
import org.springframework.web.bind.annotation.GetMapping;
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

    @RequestMapping("/wxAddOrder")
    public ResponseData wxAddOrder(int pid,String token){
        //System.out.println(pid+"+"+token);
        return wxOrderService.wxAddOrder(pid,1,token);
    }

    @GetMapping("/getOrderByStatusAndToken")
    public ResponseData getOrderByStatusAndToken(int status,String token){
        if(status==2){
            return null;
        }
        else if(status==3){
            return wxOrderService.getAllOrderByToken(token);
        }
        else {
            return wxOrderService.getOrderByStatusAndToken(status,token);
        }
    }

    @GetMapping("/getOrderDetailByCode")
    public ResponseData getOrderDetailByCode(String code){
        return wxOrderService.getOrderDetailByCode(code);
    }

}
