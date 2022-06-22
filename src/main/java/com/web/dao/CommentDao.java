package com.web.dao;

import com.web.entity.Comment;
import com.web.entity.po.CommentPo;
import com.web.entity.po.CommentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentDao {

    //通过商品id 拿到这件商品的所有评论
    List<CommentPo> getCommentById(@Param("id") int id);

    //拿到某人所有的评论
    List<CommentVo> getCommentByCusId(@Param("id") int id);


    //追加一条评论
    int addComment(Comment comment);

    //删除一条评论
    int deleteById(@Param("id") int id);



}
