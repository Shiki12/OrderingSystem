package com.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private  Integer id; //订单主键
    private  String  code; //订单号
    private  Customer customer; //下单用户
    //商品
    private  Product products;
    private Integer status; //订单状态 0 没出货 1配送中 2完成
    private Integer totalNumber; //商品总数量
    private  String address; //送达的地址
    private  String time;
    private  float total; //总价格

}
