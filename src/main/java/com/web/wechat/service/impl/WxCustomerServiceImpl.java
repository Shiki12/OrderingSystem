package com.web.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.web.dao.CustomerDao;
import com.web.entity.Customer;
import com.web.wechat.dataUtil.ResponseData;
import com.web.wechat.httpUtil.HttpClientUtil;

import com.web.wechat.service.WxCustomerService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WxCustomerServiceImpl implements WxCustomerService {

    @Autowired
    CustomerDao customerDao;

    @Override
    public ResponseData wx_login(String code, String phone, String password){
        System.out.println("wx端后台登录申请");

        try {
            //电话验证
            Customer customer = customerDao.getByPhone(phone);
            if(customer==null){
                return new ResponseData(0,"用户不存在");
            }

            //密码验证
            if(!customer.getPassword().equals(password)){
                return new ResponseData(0,"密码错误");
            }
            //AppID = wx607e482d17d2faf0
            //AppSecret = a86f77fcf21eafa7559a478109e8ed52
            //调用微信接口
      //https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
            //https://api.weixin.qq.com/sns/jscode2session?appid=wx930ffb4e79b78151&secret=8ec24d40c377f4994eadca21f37a0a1c&js_code="+code+"&grant_type=authorization_code";
            String url="https://api.weixin.qq.com/sns/jscode2session?appid=wx930ffb4e79b78151&secret=8ec24d40c377f4994eadca21f37a0a1c&js_code="+code+"&grant_type=authorization_code";

            String result= HttpClientUtil.doGet(url);
            System.out.println("code解析后的字符串"+result);

            JSONObject jsonResult = (JSONObject) JSONObject.parse(result);
            String openid = (String) jsonResult.get("openid");
            String session_key = (String) jsonResult.get("session_key");
            System.out.println("openid为："+openid);
            System.out.println("session_key为："+session_key);

            //生成token
            Md5Hash md5Token = new Md5Hash(openid, session_key, 10);
            String Token = md5Token.toString();
            customer.setToken(Token);
            customerDao.updateCustmoerToken(phone,Token);
            return new ResponseData(1,"登录成功",Token);
        }catch (Exception e){
            return new ResponseData(0,"登录异常");
        }
    }

    @Override
    public ResponseData wx_register(String name, String phone, String password) {
        try {
            System.out.println("wx端后台注册申请");

            //电话验证
            Customer customer = customerDao.getByPhone(phone);
            if(customer!=null){
                return new ResponseData(0,"用户已存在");
            }
            Customer newCustomer= new Customer(name,phone,password);
            customerDao.addCustomer(newCustomer);
            return new ResponseData(1,"注册成功");
        }catch (Exception e) {
            System.out.println(e);
            return new ResponseData(0,"注册失败");
        }

    }

}
