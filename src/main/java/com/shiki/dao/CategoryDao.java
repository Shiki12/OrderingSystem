package com.shiki.dao;


import com.shiki.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {

  List<Category> queryList();

}

