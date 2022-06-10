package com.shiki.config;

import com.shiki.dao.AdministratorDao;
import com.shiki.entity.Administrator;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/*
  管理员登录设置
 */
public class AdministratorRealm extends AuthorizingRealm {
    @Autowired
    AdministratorDao administratorDao;


    @Override //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken t = (UsernamePasswordToken) token;
        String username= token.getPrincipal().toString();
        //获取数据库中的密码
        Administrator administrator =administratorDao.selectByName(username);

        System.out.println("取出来的用户名是----->"+username);

        String passwordInDB = administrator.getPassword();

        System.out.println("取出来的密码是--------->"+passwordInDB);

        String salt = administrator.getSalt();

        System.out.println("取出来的盐是---------->"+salt);
        //盐放进去
        //这样通过spirng-shiro.xml里配置的 HashedCredentialsMatcher 进行自动校验
        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :AdminDatabaseRealm
        SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(username,passwordInDB, ByteSource.Util.bytes(salt),getName());
        return a;

    }
}
