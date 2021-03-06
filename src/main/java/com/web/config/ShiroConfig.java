package com.web.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {



    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean( @Qualifier("DefaultWebSecurityManager")
                                                                     DefaultWebSecurityManager DefaultWebSecurityManager){

        ShiroFilterFactoryBean bean =new ShiroFilterFactoryBean();


        //设置安全管理器
        bean.setSecurityManager(DefaultWebSecurityManager);

        //在这里完成请求路径的拦截 一般是管理员
        //这里完成拦截
        Map<String,String> filterMap = new LinkedHashMap<>();





        return bean;
    }




    @Bean
    public DefaultWebSecurityManager DefaultWebSecurityManager(@Qualifier("administratorRealm") AdministratorRealm administratorRealm){

        DefaultWebSecurityManager securityManager=  new DefaultWebSecurityManager();

        //  关联realm
        securityManager.setRealm(administratorRealm);

        return securityManager;
    }


    @Bean //创建了realm对象
    public AdministratorRealm administratorRealm(){

        AdministratorRealm administratorRealm = new AdministratorRealm();
        HashedCredentialsMatcher md5 = new HashedCredentialsMatcher("md5");
        md5.setHashIterations(2);

        administratorRealm.setCredentialsMatcher(md5);
        return administratorRealm;
    }

}


