package com.web.wechat.controller;

import com.web.wechat.dataUtil.ResponseData;
import com.web.wechat.service.WxProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/wx_product")
@RestController
public class WxProductController {
    @Resource
    private WxProductService wxProductService;

    @GetMapping("/getProInfos")
    public ResponseData getProInfos(){
        return wxProductService.getProInfos();
    }

    @GetMapping("/getProNum")
    public ResponseData getProNum(){
        return wxProductService.getProNum();
    }
    @GetMapping("/getProDetail")
    public ResponseData getProDetail(int id){
        return wxProductService.getProDetail(id);
    }
}
