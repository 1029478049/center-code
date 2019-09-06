package com.example.demo.service.impl;

import com.example.demo.domin.Role;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.model.RoleQueryModel;
import com.example.demo.service.AacRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hanyh
 * @create 2018-01-10 11:21
 * @desc
 **/
@Service
public class AacRoleServiceImpl implements AacRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Page<Role> queryRolePage(Role role) {
        PageHelper.startPage(role.getPage(),role.getPageSize());
        return roleMapper.selectRolePageByDomin(role);
    }

    @Override
    public Page<Role> queryUserRolePage(RoleQueryModel model) {
        PageHelper.startPage(model.getPage(),model.getPageSize());
        return roleMapper.selectUserRolePageByDomin(model);
    }

    @Override
    public Page<Role> queryUnboundUserRolePage(RoleQueryModel model) {
        PageHelper.startPage(model.getPage(),model.getPageSize());
        return roleMapper.selectUnboundUserRolePageByDomin(model);
    }

    @Override
    public int doImpowerOper(Long uId, List<Long> list) {
        return roleMapper.insertUserRole(uId,list);
    }

    @Override
    public int cancelImpowerOper(Long uId, List<Long> list) {
        return roleMapper.deletedUserRole(uId,list);
    }
}
