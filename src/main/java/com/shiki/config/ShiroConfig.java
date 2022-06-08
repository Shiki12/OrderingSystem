package com.shiki.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean( @Qualifier("DefaultWebSecurityManager")
                                                                     DefaultWebSecurityManager DefaultWebSecurityManager){

        ShiroFilterFactoryBean bean =new ShiroFilterFactoryBean();

        //设置安全管理器
        bean.setSecurityManager(DefaultWebSecurityManager);

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
        return  new AdministratorRealm();
    }

}


