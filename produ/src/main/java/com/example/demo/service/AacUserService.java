package com.example.demo.service;

import com.example.demo.DTO.query.UserQueryDTO;
import com.example.demo.DTO.result.UserResultDTO;
import com.example.demo.common.parent.Service.BaseService;
import com.example.demo.domin.User;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author Hanyh
 * @create 2017-12-12 18:19
 * @desc
 **/
public interface AacUserService extends BaseService<User>{
    /**
     * 用于登陆
     * @param user
     * @return
     */
    List<User> queryUserList(User user);

    /**
     * 用于用户表查询
     * @param user
     * @return
     */
    Page<User> queryUserPage(User user);
}
