package com.web.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *验证码类
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerCode {
     private String code;
     private Date date;
}
