package com.web.service;

import com.web.entity.Product;
import com.web.wechat.dataUtil.ResponseData;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    int addProduct(Product product);
    int update(Product product);
    Product getById(int id);
    int deleteById(int id);

}
