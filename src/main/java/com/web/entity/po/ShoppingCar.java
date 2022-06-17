package com.web.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//存放包括订单的所有数据
public class ShoppingCar {

    //所有的商品
    private List<OrderItem> orderItems;
}
