package com.web.controller;

import com.web.dao.CommentDao;
import com.web.entity.Comment;
import com.web.entity.Customer;
import com.web.entity.Order;
import com.web.entity.po.CommentPo;
import com.web.entity.po.CommentVo;
import com.web.service.CommentService;
import com.web.wechat.dataUtil.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController{


    @RequestMapping("/all")
    public String tocomment(Model model){
        List<Comment> comm = commentDao.getAllcomment();
        model.addAttribute("comm",comm);
        return "admin/comment";
    }

    @Autowired
    CommentService commentService;


    @Autowired
    CommentDao commentDao;
    //通过商品id查找到所有的评论
    @RequestMapping("/get")
    @ResponseBody
    public ResponseData getCommentById(int id){
        List<CommentPo> comments = commentService.getCommentById(id);

        if (comments!= null){
            return  new ResponseData(1,"请求成功",comments);
        }
        else {
            return  new ResponseData(0,"请求失败");
        }

    }

    @RequestMapping("/add")
    @ResponseBody //添加一条评论
    public ResponseData addComment(Comment comment){

        int i = commentService.addComment(comment);
        if (i>0){
            return new ResponseData(1,"请求成功");
        }
        else
        {
            return  new ResponseData(0,"请求失败");
        }

    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData deleteCommentById(int id){
        int i = commentService.deleteById(id);
        if (i>0){
            return new ResponseData(1,"删除成功");
        }
        else
        {
            return  new ResponseData(0,"删除失败");
        }
    }


    @RequestMapping("/getCusAllCom") //得到顾客所有的评论 通过用户id
    @ResponseBody
    public ResponseData getCusAllCom(int id, HttpSession session){

        Customer customer = (Customer) session.getAttribute("customer");
        System.out.println(customer);

        List<CommentVo> comments = commentService.getCommentByCusId(id);
        if (comments != null){
            return  new ResponseData(1,"请求成功",comments);
        }
        else
        {
            return  new ResponseData(0,"请求失败");
        }

    }







}
