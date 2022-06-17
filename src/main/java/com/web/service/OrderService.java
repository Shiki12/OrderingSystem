package com.web.service;

import com.web.entity.Customer;
import com.web.entity.Order;
import com.web.entity.po.OrderChild;
import com.web.entity.po.OrderItem;

import java.util.List;

public interface OrderService {
     List<Order> getCustomerOrder(Customer customer);

     int addBoth(OrderItem orderItem);
     int addOrderChild(OrderChild orderChild);
     //添加order订单表
     int addOrder(Order order);
     //添加orderItem订单表
     int addOrderItem(OrderItem orderItem);


}
