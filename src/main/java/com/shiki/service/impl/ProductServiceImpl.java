package com.shiki.service.impl;


import com.shiki.dao.ProductDao;
import com.shiki.entity.Product;
import com.shiki.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;


    @Override
    public List<Product> getAll() {
        List<Product> list = productDao.getAll();

        return  list;
    }

    @Override
    public int addProduct(Product product) {
        return  productDao.addProduct(product);
    }
}
