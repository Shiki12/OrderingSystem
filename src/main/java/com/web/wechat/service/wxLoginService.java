package com.web.wechat.service;

import com.web.wechat.dataUtil.ResponseData;

public interface wxLoginService {

    ResponseData wx_login(String code, String phone, String password);

}