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
    private int status;  //说明是否出货了 0  没有   1  代表出货了 2 代表已送达
    private  int cstid;

    public OrderChild(String code, String address, int status, int cstid) {
        this.code = code;
        this.address = address;
        this.status = status;
        this.cstid = cstid;
    }
}
