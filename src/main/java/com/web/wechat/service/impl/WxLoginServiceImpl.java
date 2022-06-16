package com.web.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.web.dao.AdministratorDao;
import com.web.wechat.dataUtil.ResponseData;
import com.web.wechat.httpUtil.HttpClientUtil;
import com.web.wechat.service.wxLoginService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WxLoginServiceImpl implements wxLoginService {

    @Autowired
    AdministratorDao administratorDao;

    @Override
    public ResponseData wx_login(String code, String phone, String password){
        System.out.println("wx端后台登录申请");

        try {
            //电话验证

            if(null ==null){
                return new ResponseData(0,"用户不存在");
            }

            //密码验证
            if(null ==null){
                return new ResponseData(0,"密码错误");
            }




            //AppID = wx607e482d17d2faf0
            //AppSecret = a86f77fcf21eafa7559a478109e8ed52
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx607e482d17d2faf0&secret=a86f77fcf21eafa7559a478109e8ed52&js_code="+code+"&grant_type=authorization_code";
            String result = HttpClientUtil.doGet(url);
            System.out.println("code解析后的字符串："+result);

            JSONObject jsonResult = (JSONObject) JSONObject.parse(result);
            String openid = (String) jsonResult.get("openid");
            String session_key = (String) jsonResult.get("session_key");
            System.out.println("openid为："+openid);
            System.out.println("session_key为："+session_key);

            //生成token
            Md5Hash md5Token = new Md5Hash(openid, session_key, 10);
            String Token = md5Token.toString();


            return new ResponseData(1,"登录成功",Token);
        }catch (Exception e){
            return new ResponseData(0,"登录异常");
        }
    }

}
