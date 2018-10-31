package com.example.demo.domin;

import com.example.demo.common.parent.Domin.BaseDomin;
import com.example.demo.common.parent.Domin.PageModel;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Hanyh
 * @create 2017-12-11 18:58
 * @desc
 **/
@Table(name = "u_user")
public class User extends PageModel {
    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 密码
     */
    @Column(name = "password")
    private String password;
    /**
     *最后登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;
    /**
     * 1:有效，0:禁止登录
     */
    @Column(name = "status")
    private Long status;
    /**
     * 邮件
     */
    @Column(name = "email")
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", status=" + status +
                ", email='" + email + '\'' +
                '}';
    }
}
