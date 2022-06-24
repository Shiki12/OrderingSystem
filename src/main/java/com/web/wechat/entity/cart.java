package com.web.wechat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class cart {
    private int id;
    private int pid;
    private int number;
    private String imageurl;
    private String name;
    private double price;
    private String phone;
    private boolean checked = false;
}
