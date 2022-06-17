package com.web.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class OrderChild {
    private  int id;
    private  String code;
    private String address;
    private int status;
    private  int cstid;

    public OrderChild(String code, String address, int status, int cstid) {
        this.code = code;
        this.address = address;
        this.status = status;
        this.cstid = cstid;
    }
}
