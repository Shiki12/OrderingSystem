package com.web.wechat.service;

import com.web.wechat.dataUtil.ResponseData;

public interface WxOrderService {
    ResponseData getOrderByToken(String token);

    ResponseData addOrder(int pid,int number, String token);

    ResponseData getOrderByStatusAndToken(int status, String token);

    ResponseData getAllOrderByToken(String token);

    ResponseData getOrderDetailByCode(String code);
}
