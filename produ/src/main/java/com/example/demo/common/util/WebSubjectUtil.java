package com.example.demo.common.util;

import com.example.demo.domin.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Web端获取当前登陆用户名
 */
public class WebSubjectUtil {

    public static User getUser() {
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) subject.getPrincipal();
        if (principal != null) {
            return principal;
        } else {
            principal = new User();
            principal.setId(0L);
        }
        return principal;

    }

    public static boolean isLogin(){
        return getUser() != null && getUser().getId() != null && getUser().getId() > 0;
    }
}
