package com.web.wechat.service.impl;

import com.web.dao.OrderDao;
import com.web.entity.Order;
import com.web.wechat.dataUtil.ResponseData;
import com.web.wechat.service.WxOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxOrderServiceImpl implements WxOrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public ResponseData getOrderByToken(String token) {
        try {
            List<Order> orderList=orderDao.getOrderByToken(token);
            for(Object s:orderList){
                System.out.println(s);
            }
            return new ResponseData(1,"通过token查询用户购物车");
        }catch (Exception e){
            return new ResponseData(0,"未知异常，请查看后台");
        }
    }
}
