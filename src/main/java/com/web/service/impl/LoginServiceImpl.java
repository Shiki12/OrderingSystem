package com.web.service.impl;

import com.web.dao.AdministratorDao;
import com.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AdministratorDao administratorDao;



}
