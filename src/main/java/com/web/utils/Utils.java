package com.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String getStringDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间
        String[] strings = date.toString().split("-");
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : strings) {
            if (string != null) stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }


}