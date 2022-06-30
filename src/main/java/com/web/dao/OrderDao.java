package com.web.dao;


import com.web.entity.Customer;
import com.web.entity.Order;
import com.web.wechat.entity.cart;
import com.web.wechat.entity.wxOrder;
import com.web.wechat.entity.wxOrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//订单接口
@Mapper
public interface OrderDao {
    //得到某人的订单
    Order getCustomerOrderById(Customer customer);

    List<cart> getOrderByToken(String token);

    boolean wxAddOrder(int pid, int cid ,int number);

    List<wxOrder> getOrderByStatusAndToken(int status, String token);

    List<wxOrder> getAllOrderByToken(String token);

    List<wxOrderDetail> getOrderDetailByCode(String code);
}
