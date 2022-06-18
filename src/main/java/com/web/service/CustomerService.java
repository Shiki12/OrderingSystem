package com.web.service;

import com.web.entity.Customer;

import java.util.List;

public interface CustomerService {
    int addCustomer(Customer customer) ;
    int update(Customer customer);
    List<Customer> getAll();
    Customer getById(int id) ;
    Customer getByName(String name) ;
    int deleteById(int id);

}
