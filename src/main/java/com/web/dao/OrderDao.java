package com.web.dao;


import com.web.entity.Customer;
import com.web.entity.Order;

//订单接口
public interface OrderDao {
    //得到某人的订单
    Order getCustomerOrderById(Customer customer);

}
