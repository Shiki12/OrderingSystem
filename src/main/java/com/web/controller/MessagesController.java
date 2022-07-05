package com.web.controller;

import com.web.dao.MessageDao;
import com.web.entity.LeavingMessages;
import com.web.wechat.dataUtil.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessagesController {

    @Autowired
    MessageDao messageDao;

    //得到某件商品的评论
    @RequestMapping("/getAllMes")
    public ResponseData getOneProMes(Model model){
        List<LeavingMessages> list = messageDao.getAll();
            model.addAttribute("message",list);
            return new ResponseData(1,"请求成功",list);
    }

    @RequestMapping("/add")
    public ResponseData add(LeavingMessages message){
        int i = messageDao.addMessage(message);
        if (i!=0){
          return   new ResponseData(1,"请求成功");
        }
        else {
            return   new ResponseData(1,"请求失败");
        }
    }

    @RequestMapping("/delete/{id}")
    public ResponseData delete(@PathVariable("id") int id){
        int i = messageDao.deleteById(id);
        if (i!=0){
            return   new ResponseData(1,"请求成功");
        }
        else {
            return   new ResponseData(1,"请求失败");
        }
    }


}
