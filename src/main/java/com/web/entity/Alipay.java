package com.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alipay {
    private String subject;  //名称
    private String traceNo;  //订单号
    private String totalAmount;  //总金额
}
