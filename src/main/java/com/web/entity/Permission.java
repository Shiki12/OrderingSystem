package com.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/*
* 权限类
* */
public class Permission {
    private Long id;
    private String name;
    private String desc_;
    private String url;
}
