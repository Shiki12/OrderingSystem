package com.web.service;

import com.web.entity.Comment;
import com.web.entity.po.CommentPo;
import com.web.entity.po.CommentVo;

import java.util.List;

public interface CommentService {
    //通过商品id 拿到这件商品的所有评论
    List<CommentPo> getCommentById( int id);


    //拿到某人所有的评论
    List<CommentVo> getCommentByCusId(int id);



    //追加一条评论
    int addComment(Comment comment);

    //删除一条评论
    int deleteById( int id);

}
