package com.example.demo.shiro;

import com.example.demo.common.util.MD5Util;
import com.example.demo.domin.User;
import com.example.demo.facade.AacUserFacade;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hanyh
 * @create 2017-12-11 18:23
 * @desc
 **/
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private AacUserFacade aacUserFacade;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        System.out.println("身份认证方法：MyShiroRealm.doGetAuthenticationInfo()");

        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Map<String, Object> map = new HashMap<String, Object>();
        String pmd = new String(token.getPassword());
        map.put("username", token.getUsername());
        User user = null;
        // 从数据库获取对应用户名密码的用户
        List<User> userList = aacUserFacade.queryUserByMap(map).getResult();
        if(userList.size() == 0){
            throw new AccountException("用户名不存在!");
        }else if(userList.size()!=0){
            if(userList.get(0).getPassword().equals(MD5Util.MD5(pmd,"utf-8"))){
                user = userList.get(0);
            }else{
                throw new AccountException("密码不匹配！");
            }
        }
        if(user.getStatus()==0){
            /**
             * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
             */
            throw new DisabledAccountException("帐号已经禁止登录！");
        }else{
            //更新登录时间 last login time
            user.setLastLoginTime(new Date());
            //sysUserService.updateById(user);//// TODO: 2017/12/12  
        }
        return new SimpleAuthenticationInfo(user, token.getPassword(), getName());
    }
}
