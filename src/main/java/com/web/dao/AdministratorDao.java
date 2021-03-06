package com.web.dao;

import com.web.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface AdministratorDao {
    Administrator selectById(@Param("id") int id);
    Administrator selectByName(@Param("name")String name);
    int update(Administrator administrator);
}
