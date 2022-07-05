package com.web.controller;

import com.web.dao.MessageDao;
import com.web.entity.LeavingMessages;
import com.web.wechat.dataUtil.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessagesController {

    @Autowired
    MessageDao messageDao;

    //得到某件商品的评论
    @RequestMapping("/getAllMes")
    public ResponseData getOneProMes(Model model){
        List<LeavingMessages> list = messageDao.getAll();
            model.addAttribute("message",list);
            return new ResponseData(1,"?",list);
    }



}
