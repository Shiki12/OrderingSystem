package com.web.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
* 评论类
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {


    private  String content;
    private  Integer pid; //商品id
    private  Integer cstid; //顾客id
    private  Date createtime;//评论的时间



}
