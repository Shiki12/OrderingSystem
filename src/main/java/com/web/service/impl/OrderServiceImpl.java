package com.web.service.impl;

import com.web.dao.CustomerDao;
import com.web.dao.OrderDao;
import com.web.dao.ProductDao;
import com.web.entity.Alipay;
import com.web.entity.Customer;
import com.web.entity.Order;
import com.web.entity.po.OrderChild;
import com.web.entity.po.OrderItem;
import com.web.entity.po.ProductChild;
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


    //需要返回一个Alipay 对象
    @Override   //传进来的是一个商品类   一个订单一个商品情况
    public Alipay addBoth(OrderItem orderItem) {
        Alipay alipay  =new Alipay();
        int count = orderDao.count(); //得到最大的订单id
        OrderChild orderChild = new OrderChild();
        orderChild.setId(count+1); //设置新买的订单id
        orderItem.setOid(count+1); // 绑定订单id
        try {
            //现在需要添加进order表  订单表
            // 这里随机产生一堆数用来构成订单编号
            String stringDate = Utils.getStringDate()+Utils.genId();
            orderChild.setCode(stringDate);
            //设置顾客的id
            orderChild.setCstid(orderItem.getCstid());
            //设置地址
            orderChild.setAddress(orderItem.getAddress());
            //标志是否出货
            orderChild.setStatus(0); //默认是没出货的

            //添加进order表
            addOrderChild(orderChild);

            //设置返回的单号
            alipay.setTraceNo(stringDate);

            //设置总金额
           // alipay.setTotalAmount();

            ProductChild child = orderDao.selectPriceAndName(orderItem.getPid());

            double totalPrice = child.getPrice() * orderItem.getNumber();
            alipay.setTotalAmount(String.valueOf(totalPrice));

            alipay.setSubject(child.getName());

            String time = Utils.getTime();
            orderItem.setTime(time);
            // 添加商品
            addOrderItem(orderItem); //添加进了orderItem表 即添加了商品
        }catch (Exception e){
            return null;
        }
        return  alipay;
    }

    @Override    //这个针对的是一个订单多件商品的情况
    public int addSomeOrders(List<OrderItem> orderItem) {
        int count = orderDao.count(); //得到最大的订单id
        OrderChild orderChild = new OrderChild();
        orderChild.setId(count+1); //设置新买的订单id   0
        //因为地址都是一样的所以说
        //单独提取
        try {
            OrderItem item = orderItem.get(0);
            orderChild.setAddress(item.getAddress()); //设置订单的地址
            //接着添加本次订单的商品
            String stringDate = Utils.getStringDate()+Utils.genId();
            orderChild.setCode(stringDate);
            //设置顾客的id
            orderChild.setCstid(item.getCstid());
            //标志是否出货
            orderChild.setStatus(0); //默认是没出货的
            //添加进order表
            addOrderChild(orderChild);

            for (OrderItem orderItem1 : orderItem) {
                addOrderItem(orderItem1);
            }
        }
        catch (Exception e){
            return 0;
        }
        return 1;
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
