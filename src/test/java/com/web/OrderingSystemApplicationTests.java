package com.web;

import com.web.dao.AdministratorDao;
import com.web.entity.Administrator;
import com.web.entity.Product;
import com.web.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class OrderingSystemApplicationTests {
    @Autowired
    AdministratorDao administratorDao;

    @Autowired
    ProductService productService;

    @Test
    void contextLoads() {


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
}