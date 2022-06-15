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
    private  String  token; //保留令牌
    private String phone;

}
