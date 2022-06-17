package com.web.dao;

import com.web.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductDao {
    List<Product> getAll();
    int addProduct(Product product);
    int update(Product product);
    Product getById(@Param("id") int id);
    int deleteById(@Param("id") int id);

    //模糊查询
    List<Product> fuzzyQuery(String key);

    List<Integer> getProNum();
    Product getOnlineById(@Param("id")int id);
}
