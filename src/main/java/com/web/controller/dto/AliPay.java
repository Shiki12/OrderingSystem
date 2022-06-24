package com.web.controller.dto;

import lombok.Data;

@Data
public class AliPay {
    private String subject;  //名称
    private String traceNo;  //
    private String totalAmount;  //总金额
}
