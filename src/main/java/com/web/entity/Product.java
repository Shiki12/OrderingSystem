package com.web.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Integer id;
    private  String name;
    private  float price;
    private  int zan;
    private  int number;  //出售数量
    private  int status;  // 商品状态
    private  String imageUrl; //图片地址
    private  String miaoshu;  //详细信息
    private  int cid; // 种类id
    private  int bid; //是哪个上线的


}
