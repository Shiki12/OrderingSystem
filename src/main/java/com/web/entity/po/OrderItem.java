package com.web.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//存放每一条数据
public class OrderItem {
    private  int id;
    private  int pid;
    private  int oid;
    private  int cstid;
    private  String  time;
    private String address;
    private  int number;
    public OrderItem(int pid, int oid, int cstid, int number,String address) {
        this.pid = pid;
        this.oid = oid;
        this.cstid = cstid;
        this.number = number;
        this.address = address;
    }


}