package com.web.service.impl;

import com.web.dao.CommentDao;
import com.web.entity.Comment;
import com.web.entity.po.CommentPo;
import com.web.entity.po.CommentVo;
import com.web.service.CommentService;
import com.web.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    CommentDao commentDao;

    @Override
    public List<CommentPo> getCommentById(int id) {
        return  commentDao.getCommentById(id);
    }

    @Override
    public List<CommentVo> getCommentByCusId(int id) {
        return commentDao.getCommentByCusId(id);
    }


    @Override
    public int addComment(Comment comment) {
        String time = Utils.getTime();
        comment.setCreatetime(time);
         return commentDao.addComment(comment);
    }

    @Override
    public int deleteById(int id) {
         return  commentDao.deleteById(id);
    }
}
