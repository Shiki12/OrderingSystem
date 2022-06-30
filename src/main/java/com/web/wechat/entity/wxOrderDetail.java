package com.web.wechat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class wxOrderDetail {
    private int id;
    private String name;
    private double price;
    private int number;
}
