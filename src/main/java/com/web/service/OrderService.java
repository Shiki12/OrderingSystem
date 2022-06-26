package com.web.service;

import com.web.entity.Alipay;
import com.web.entity.Customer;
import com.web.entity.Order;
import com.web.entity.po.OrderChild;
import com.web.entity.po.OrderItem;

import java.util.List;

public interface OrderService {
     List<Order> getCustomerOrder(Customer customer);


     //一个订单一件商品
     Alipay addBoth(OrderItem orderItem);

     int addSomeOrders(List<OrderItem> orderItem);
     int addOrderChild(OrderChild orderChild);
     //添加order订单表
     int addOrder(Order order);
     //添加orderItem订单表
     int addOrderItem(OrderItem orderItem);


}
