package com.shiki.service.impl;

import com.shiki.dao.AdministratorDao;
import com.shiki.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AdministratorDao administratorDao;



}
