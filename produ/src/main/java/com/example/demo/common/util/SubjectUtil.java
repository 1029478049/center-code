package com.example.demo.common.util;

import com.example.demo.common.util.context.PlatformContext;
import com.example.demo.common.util.excption.BusinessException;
import com.example.demo.domin.User;

/**
 * 不好使
 * Shiro获取当前登录用户信息
 */
public class SubjectUtil {
    /**
     * 当前用户KEY
     */
    public static final String CURRENT_USER_KEY = "_CURRENT_USER_";

    public static User getUser() {
        try {
            // 获取上下文中的当前用户信息
            User loginUser = (User) PlatformContext.getVariable(CURRENT_USER_KEY);
            if (loginUser != null) {
                return loginUser;
            } else {
                loginUser = new User();
                loginUser.setUserName("1");
            }
            return loginUser;
        } catch (Exception e) {
            throw new BusinessException("获取当前用户信息失败：" + e.getMessage());
        }
    }

    public static void setUser(User loginUser){
        try {
            PlatformContext.setVariable(CURRENT_USER_KEY, loginUser);
        } catch (Exception e) {
            throw new BusinessException("设置当前用户信息失败：" + e.getMessage());
        }
    }
}
