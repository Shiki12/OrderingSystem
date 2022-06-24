package com.web.wechat.controller;


import com.web.wechat.dataUtil.ResponseData;
import com.web.wechat.service.WxCustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RequestMapping("/wechat")
@RestController
public class WxCustomerController {

    @Resource
    private WxCustomerService wxCustomerService;

    /**
     * wx端登录
     * @param phone 电话
     * @param code  请求openid 和 session_key
     * @return  状态码 success:1 fail:0
     */
    @RequestMapping("/login")
    public ResponseData wx_Login(String code, String phone, String password){
        return wxCustomerService.wx_login(code,phone,password);
    }

    @RequestMapping("/customerRegister")
    public ResponseData wx_register(String name,String phone,String password){
        return wxCustomerService.wx_register(name,phone,password);
    }

    @GetMapping("/getUserInfo")
    public ResponseData wx_getUserInfo(String token){
        return wxCustomerService.wx_getUserInfo(token);
    }

    @RequestMapping("/updateUserInfo")
    public ResponseData wx_updateUserInfo(String token,String name,String phone,String address){
        return wxCustomerService.wx_updateUserInfo(token,name,phone,address);
    }

    @RequestMapping("/updateUserPwd")
    public ResponseData wx_updateUserPwd(){
        return null;
    }
}
