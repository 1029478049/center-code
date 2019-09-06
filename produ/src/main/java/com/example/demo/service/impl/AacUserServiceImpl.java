package com.example.demo.service.impl;

import com.example.demo.common.parent.Mapper.IMapper;
import com.example.demo.common.parent.Service.Impl.BaseServiceImpl;
import com.example.demo.domin.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.AacUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hanyh
 * @create 2017-12-12 18:20
 * @desc
 **/
@Service
public class AacUserServiceImpl extends BaseServiceImpl<User> implements AacUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    protected IMapper<User> getBaseMapper() {
        return userMapper;
    }
    @Override
    public List<User> queryUserList(User user) {
        return userMapper.selectUserByDomin(user);
    }

    @Override
    public Page<User> queryUserPage(User user) {
        PageHelper.startPage(user.getPage(),user.getPageSize());
        return userMapper.selectUserPageByDomin(user);
    }
}
