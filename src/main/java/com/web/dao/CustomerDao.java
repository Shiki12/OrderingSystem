package com.web.dao;

import com.web.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerDao {

    int addCustomer(Customer customer);

    List<Customer> getAll();

    Customer getById(@Param("id")  int id);

    int deleteById(@Param("id")  int id);

    Customer getByPhone(String phone);

    void update(Customer customer);

    void updateCustmoerToken(String phone, String token);

    Customer getCustomerByToken(String token);
}
