package com.web.service.impl;

import com.web.dao.CustomerDao;
import com.web.dao.OrderDao;
import com.web.dao.ProductDao;
import com.web.entity.Customer;
import com.web.entity.Order;
import com.web.entity.po.OrderChild;
import com.web.entity.po.OrderItem;
import com.web.service.OrderService;
import com.web.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    ProductDao productDao;


    @Autowired
    CustomerDao customerDao;


    @Override
    public List<Order> getCustomerOrder(Customer customer) {
        List<Order> orders = orderDao.getCustomerOrderById(customer);
        return orders;
    }

    @Override
    public int addBoth(OrderItem orderItem) {

        OrderChild orderChild = new OrderChild();
        int i ,j;
        try {
          i =   addOrderItem(orderItem); //添加进了orderItem表
            //现在需要添加进order表
            String stringDate = Utils.getStringDate();
            orderChild.setCode(stringDate);
            orderChild.setCstid(orderItem.getCstid());
            orderChild.setAddress(orderItem.getAddress());
            orderChild.setStatus(0); //默认是没出货的
            //添加进order表
            j=addOrderChild(orderChild);
        }catch (Exception e){
            return 0;
        }
        return  i+j;
    }

    @Override
    public int addOrderChild(OrderChild orderChild) {
        return orderDao.addOrderChild(orderChild);
    }

    @Override
    public int addOrderItem(OrderItem orderItem) {
        return orderDao.addOrderItem(orderItem);
    }

    @Override
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }
}
