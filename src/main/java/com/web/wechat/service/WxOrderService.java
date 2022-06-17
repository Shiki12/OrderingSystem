package com.web.wechat.service;

import com.web.wechat.dataUtil.ResponseData;

public interface WxOrderService {
    ResponseData getOrderByToken(String token);
}
