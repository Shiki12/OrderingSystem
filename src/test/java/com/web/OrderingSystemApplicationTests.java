package com.web;

import com.web.dao.AdministratorDao;
import com.web.dao.OrderDao;
import com.web.entity.Administrator;
import com.web.entity.Customer;
import com.web.entity.Order;
import com.web.entity.Product;
import com.web.entity.po.OrderItem;
import com.web.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class OrderingSystemApplicationTests {
    @Autowired
    AdministratorDao administratorDao;

    @Autowired
    ProductService productService;

    @Autowired
    OrderDao  orderDao;


    @Test
    void contextLoads() {
        System.out.println(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
    }

    @Test
    void test1() {
        Administrator administrator = administratorDao.selectById(1);
        System.out.println(administrator);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //得到上次登陆的时间
        Date time = administrator.getLasttime();
        //上次时间
        String lastLoginTime = sdf.format(time);
        //当前时间
        String format = sdf.format(new Date());
        //string转date  不处理时间格式会不理想
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = sdf.parse(format, pos);
        administrator.setLasttime(strtodate);
        administratorDao.update(administrator);

    }

    @Test
    void testSql(){
       productService.addProduct(new Product("shiki",15,15,25,1,"/images/product/3.jpg","hthh"
               ,1,1));


    }

    @Test
    void testOrder(){
        List<Order> orderById = orderDao.getCustomerOrderById(new Customer(1));
        for (Order order : orderById) {
            System.out.println(order);
//            System.out.println("本次订单共有--------->"+order.getProducts().size());
//            for (Product product : order.getProducts()) {
//                System.out.println("当前用户名"+order.getCustomer());
//                System.out.println("该用户下的订单是：");
//                System.out.println(product);
//            }

        }
    }

    @Test
    void testPlaceOrder(){
        OrderItem orderItem = new OrderItem(6, 1, 1, 15,"地址");

        OrderItem[] orderItems = new OrderItem[100];
        orderItems[0]= orderItem;
        orderItems[1]= orderItem;
        orderItems[2]= orderItem;
        //添加了订单
        orderDao.addOrderItem(orderItems[0]);
        orderDao.addOrderItem(orderItems[1]);
        orderDao.addOrderItem(orderItems[2]);

    }

    @Test
    void testSearch(){
        List<Product> list = productService.fuzzyQuery("蛋糕");
        for (Product product : list) {
            System.out.println(product);
        }
    }
}