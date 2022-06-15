package com.web.dao;


import com.web.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {
  List<Category> queryList();
}

