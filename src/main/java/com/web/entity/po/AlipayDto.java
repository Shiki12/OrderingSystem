package com.web.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlipayDto {
    private  int id;
    private  String code;
    private int number;
    private String name;
    private  double price;
}
