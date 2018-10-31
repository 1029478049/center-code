package com.example.demo.common.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @author Hanyh
 * @create 2017-12-11 15:06
 * @desc
 **/
public class ShiroUtil {
    private static final Logger logger = LogManager.getLogger(ShiroUtil.class);
    public static Subject login(String configFile, String userName, String pasword){
        // 1、读取配置文件，初始化SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
        // 2、获取securityManager实例
        SecurityManager securityManager = factory.getInstance();
        //3、把securityManager实例绑定到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        // 4、得到当前执行的用户
        Subject currentUser = SecurityUtils.getSubject();
        // 5、创建token令牌，用户名/密码
        UsernamePasswordToken token = new UsernamePasswordToken(userName,pasword);
        try{
            // 身份认证
            currentUser.login(token);
            logger.info("身份认证成功");
        }catch (AuthenticationException e){
            logger.error("身份认证失败",e);
        }
        return currentUser;
    }
}
