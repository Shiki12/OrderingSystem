package com.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
  留言
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeavingMessages {
    private  Integer id;
    private String content;
    private  Integer cstid;
    private  Integer status; //审核状态
    private  String fabudate; //发布时间

}
