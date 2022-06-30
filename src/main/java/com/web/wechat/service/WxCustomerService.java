package com.web.wechat.service;

import com.web.wechat.dataUtil.ResponseData;

public interface WxCustomerService {

    ResponseData wx_login(String code, String phone, String password);

    ResponseData wx_register(String name, String phone, String password);

    ResponseData wx_getUserInfo(String token);

    ResponseData wx_updateUserInfo(String token,String name, String phone, String address);

    ResponseData wx_updateUserPwd(String token,String newPwd);
}