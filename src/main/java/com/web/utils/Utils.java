package com.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


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

    public static int genId(){
        Random random = new Random();
        int number=random.nextInt(9000000)+1000000;
        return number;
    }

    //得到目前的时间
    public static String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间
       return date;
    }

    public static  int getRandomNumber(){
        Random random = new Random();
        int number=random.nextInt(900000)+100000;
        return number;
    }

    //算出时间差了多少分钟
    public static int compare(Date date,Date date1){
        return (int) (date1.getTime() - date.getTime()) / (60 * 1000);
    }



}