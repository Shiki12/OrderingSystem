package com.shiki.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private  Integer id;
    private  String  code; //订单号
    private  Customer customer; //下单用户
    private Integer status; //订单状态 0 没出货 1配送中 2完成
    private Integer totalNumber; //总数量
    private  float total; //总价格

}
