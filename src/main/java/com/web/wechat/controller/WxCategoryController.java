package com.web.wechat.controller;

import com.web.entity.Category;
import com.web.wechat.service.WxCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/wx_category")
@RestController
public class WxCategoryController {

    @Resource
    private WxCategoryService wxCategoryService;

    @GetMapping("/getAll")
    public List<String> getAll(){
        return wxCategoryService.getAll();
    }


}
