package com.web.dao;

import com.web.entity.LeavingMessages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageDao {
    int addMessage(LeavingMessages messages);
    int deleteById(@Param("id") int id);
    int updateById(@Param("id") int id);
    List<LeavingMessages> getAll();
}
