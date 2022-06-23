package com.web.dao;


import com.web.entity.Customer;
import com.web.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//订单接口
@Mapper
public interface OrderDao {
    //得到某人的订单
    Order getCustomerOrderById(Customer customer);

    List<Order> getOrderByToken(String token);

    boolean addOrder(int pid, int cid ,int number);
}
