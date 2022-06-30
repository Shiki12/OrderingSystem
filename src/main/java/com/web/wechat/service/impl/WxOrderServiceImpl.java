package com.web.wechat.service.impl;

import com.web.dao.CustomerDao;
import com.web.dao.OrderDao;
import com.web.entity.Customer;
import com.web.wechat.dataUtil.ResponseData;
import com.web.wechat.entity.cart;
import com.web.wechat.entity.wxOrder;
import com.web.wechat.entity.wxOrderDetail;
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
            List<cart> orderList=orderDao.getOrderByToken(token);
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
            orderDao.wxAddOrder(pid,customer.getId(),number);
            return new ResponseData(1,"添加成功");
        }catch (Exception e){
            return new ResponseData(0,"未知异常，请查看后台");
        }
    }

    @Override
    public ResponseData getOrderByStatusAndToken(int status, String token) {
        try {
            List<wxOrder> orderList = orderDao.getOrderByStatusAndToken(status,token);
            for(Object s:orderList){
                System.out.println(s);
            }

            return new ResponseData(1,"查询成功",orderList);
        }catch (Exception e){
            return new ResponseData(0,"未知异常，请查看后台");
        }
    }

    @Override
    public ResponseData getAllOrderByToken(String token) {
        try {
            List<wxOrder> orderList = orderDao.getAllOrderByToken(token);
            for(Object s:orderList){
                System.out.println(s);
            }

            return new ResponseData(1,"查询成功",orderList);
        }catch (Exception e){
            return new ResponseData(0,"未知异常，请查看后台");
        }
    }

    @Override
    public ResponseData getOrderDetailByCode(String code) {
        try {
            List<wxOrderDetail> orderDetailList = orderDao.getOrderDetailByCode(code);

//            for(Object s:orderDetailList){
//                System.out.println(s);
//            }

            return new ResponseData(1,"查询成功",orderDetailList);
        }catch (Exception e){
            return new ResponseData(0,"未知异常，请查看后台");
        }
    }


}
