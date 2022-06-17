package com.web.service.impl;


import com.web.dao.ProductDao;
import com.web.entity.Product;
import com.web.service.ProductService;
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

    @Override
    public int update(Product product) {
        return productDao.update(product);
    }

    @Override
    public Product getById(int id) {
       return productDao.getById(id);
    }

    @Override
    public int deleteById(int id) {
        return productDao.deleteById(id);
    }

    @Override
    public List<Product> fuzzyQuery(String key) {
        return productDao.fuzzyQuery(key);
    }


}
