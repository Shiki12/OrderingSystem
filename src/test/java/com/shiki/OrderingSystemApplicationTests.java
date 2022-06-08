package com.shiki;

import com.shiki.dao.AdministratorDao;
import com.shiki.entity.Administrator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderingSystemApplicationTests {
    @Autowired
    AdministratorDao administratorDao;
    @Test
    void contextLoads() {


    }

    @Test
    void test1(){
        Administrator administrator = administratorDao.selectById(1);
        System.out.println(administrator);
    }
}
