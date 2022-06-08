package com.shiki.dao;

import com.shiki.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AdministratorDao {
    public Administrator selectById();
}
