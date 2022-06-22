package com.web.dao;

import com.web.entity.LeavingMessages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageDao {
    int addMessage(LeavingMessages messages);
    int deleteById(@Param("id") int id);
}
