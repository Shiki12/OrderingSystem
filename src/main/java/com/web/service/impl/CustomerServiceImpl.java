package com.web.service.impl;

import com.web.dao.CustomerDao;
import com.web.entity.Customer;
import com.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;


    @Override
    public int addCustomer(Customer customer) {
        return  customerDao.addCustomer(customer);
    }

    @Override
    public int update(Customer customer) {
        return customerDao.update(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Override
    public Customer getById(int id) {
        return customerDao.getById(id);
    }

    @Override
    public int deleteById(int id) {
        return customerDao.deleteById(id);
    }
}
