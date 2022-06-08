package com.shiki.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色表
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    /**
     * 一共分为三个等级 超级管理员
     *    商品管理员
     *    一般人员
     */

    private  int level;
    private  String  name;
    private  String des;//描述用户等级

}
