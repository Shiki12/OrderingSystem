package com.web.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.web.entity.Alipay;
import com.web.service.AlipayService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AlipayServiceImpl implements AlipayService{

    @Value("${alipay.appid}")
    private String appid;
    @Value("${alipay.url}")
    private String url;
    @Value("${alipay.privateKey}")
    private String privateKey;
    @Value("${alipay.publicKey}")
    private String publicKey;
    @Value("${alipay.notifyUrl}")
    private String notifyUrl;
    @Value("${alipay.returnUrl}")
    private String returnUrl;


    @Override
    public String pay(Alipay alipay) {
        AlipayClient alipayClient = new DefaultAlipayClient(url,appid,privateKey,"json","UTf-8",publicKey,"RSA2");
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setNotifyUrl(notifyUrl);
        request.setReturnUrl(returnUrl);
        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", alipay.getTraceNo());
        bizContent.put("total_amount", alipay.getTotalAmount());
        bizContent.put("subject", alipay.getSubject());
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");

        request.setBizContent(bizContent.toString());
        AlipayTradePagePayResponse response = null;
        String form = null;
        try {
            response = alipayClient.pageExecute(request);
            form = response.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
        return form;
    }
}
