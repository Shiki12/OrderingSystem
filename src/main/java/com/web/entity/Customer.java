package com.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private  int id;
    private  String  name;
    private  String  password;
    private  String  address; //地址
    private  int  shoppingCart; //购物车状态 0下单
    private  int status; // 0:普通用户 1:会员
    private  String  token; //保留令牌  对应数据库status字段
    private String phone;

}
