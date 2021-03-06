package com.web;

import com.web.dao.AdministratorDao;
import com.web.dao.CommentDao;
import com.web.dao.MessageDao;
import com.web.dao.OrderDao;
import com.web.entity.*;
import com.web.entity.po.AlipayDto;
import com.web.entity.po.CommentVo;
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

    @Autowired
    CommentDao commentDao;

    @Autowired
    MessageDao messageDao;


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


    }

    @Test
    void testSearch(){
        List<Product> list = productService.fuzzyQuery("蛋糕");
        for (Product product : list) {
            System.out.println(product);
        }
    }

    @Test
    void testComment(){
        List<CommentVo> comment = commentDao.getCommentByCusId(1);
        for (CommentVo commentVo : comment) {

            System.out.println(commentVo);
        }

    }

    @Test
    void testMessage(){
        List<LeavingMessages> all = messageDao.getAll();
        for (LeavingMessages leavingMessages : all) {
            System.out.println(leavingMessages);
        }
    }

    @Test
    void testAlipay(){
        List<AlipayDto> alipayDtos = orderDao.selectAlipay(1);
        for (AlipayDto alipayDto : alipayDtos) {
            System.out.println(alipayDto);
        }
    }

    @Test
    void testAddOrderShop(){
//        OrderItem orderItem = new OrderItem();
//        orderItem.setPid(1);
//        orderItem.setCstid(1);
//        orderItem.setNumber(10);
//        orderDao.addOrderShop(orderItem);


        List<Order> list = orderDao.getOrderShop(1);

        for (Order orderItem : list) {
            System.out.println(orderItem);
        }
    }
}