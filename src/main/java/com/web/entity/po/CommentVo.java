package com.web.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo {
    private  int id;
    private String  username;
    private  String content;
    private  String time;
    private  String imageUrl; //商品地址
    private  String proName; //商品名称
}
