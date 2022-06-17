package com.web.wechat.controller;


import com.web.wechat.dataUtil.ResponseData;
import com.web.wechat.service.wxLoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RequestMapping("/wechat")
@RestController
public class WxLoginController {

    @Resource
    private wxLoginService wxloginService;

    /**
     * wx端登录
     * @param phone 电话
     * @param code  请求openid 和 session_key
     * @return  状态码 success:1 fail:0
     */
    @RequestMapping("/login")
    public ResponseData wx_Login(String code, String phone, String password){
        return wxloginService.wx_login(code,phone,password);
    }

}
