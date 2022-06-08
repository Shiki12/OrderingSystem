package com.shiki.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//管理员表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {

    private Long id;

    private String name;

    private String password;

    private String salt;

    private Integer status;

    private String address;

    private String phone;

    private Date lasttime;

}
