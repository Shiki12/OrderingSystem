package com.web.dao;

import com.web.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    List<Product> getOneType(@Param("id")int id);


    //数据可视化得到剩余数量最多的食物
    @Select("select id,name,number from product order by number desc LIMIT 0,8")
    List<Product> getLastMost();



}
