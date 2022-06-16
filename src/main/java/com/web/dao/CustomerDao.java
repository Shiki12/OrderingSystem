package com.web.dao;

import com.web.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerDao {
    int addCustomer(Customer customer) ;
    int update(Customer customer);
    List<Customer> getAll();
    Customer getById( int id) ;
    int deleteById(int id);


}
