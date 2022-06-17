package com.web.dao;


import com.web.entity.Customer;
import com.web.entity.Order;
import com.web.entity.po.OrderChild;
import com.web.entity.po.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//订单接口
@Mapper
public interface OrderDao {
    //得到某人的订单
    List<Order> getCustomerOrderById(Customer customer);

    //添加order_表
    int addOrder(Order order);

    //添加 order_item
    int addOrderItem(OrderItem orderItem);

    int addOrderChild(OrderChild orderChild);

    List<Order> getOrderByToken(String token);
}
