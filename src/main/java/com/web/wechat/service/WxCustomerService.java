package com.web.wechat.service;

import com.web.wechat.dataUtil.ResponseData;

public interface WxCustomerService {

    ResponseData wx_login(String code, String phone, String password);

    ResponseData wx_register(String name, String phone, String password);
}