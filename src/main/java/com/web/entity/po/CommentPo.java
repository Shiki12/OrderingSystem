package com.web.entity.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 用来接收查询到的评论
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentPo {
private  int id;
    private String  username;
    private  String content;
    private  String time;

}
