package com.web.dao;

import com.web.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductDao {
    List<Product> getAll();
    int addProduct(Product product);
    int update(Product product);
    Product getById(@Param("id") int id);
    int deleteById(@Param("id") int id);
}
