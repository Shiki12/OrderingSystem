package com.web.wechat.service.impl;

import com.web.dao.CustomerDao;
import com.web.dao.OrderDao;
import com.web.entity.Customer;
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

    @Autowired
    CustomerDao customerDao;

    @Override
    public ResponseData getOrderByToken(String token) {
        try {
            List<Order> orderList=orderDao.getOrderByToken(token);
//            for(Object s:orderList){
//                System.out.println(s);
//            }
            return new ResponseData(1,"通过token查询用户购物车",orderList);
        }catch (Exception e){
            return new ResponseData(0,"未知异常，请查看后台");
        }
    }

    @Override
    public ResponseData addOrder(int pid, int number,String token) {
        try {
            Customer customer = customerDao.getCustomerByToken(token);
            boolean result=orderDao.addOrder(pid,customer.getId(),number);
            System.out.println(result);

            return new ResponseData(1,"添加成功");
        }catch (Exception e){
            return new ResponseData(0,"未知异常，请查看后台");
        }
    }
}
