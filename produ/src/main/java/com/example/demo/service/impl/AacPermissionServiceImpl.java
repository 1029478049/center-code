package com.example.demo.service.impl;

import com.example.demo.domin.Permission;
import com.example.demo.mapper.PermissionMapper;
import com.example.demo.model.PermissionQueryModel;
import com.example.demo.service.AacPermissionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hanyh
 * @create 2018-01-10 11:31
 * @desc
 **/
@Service
public class AacPermissionServiceImpl implements AacPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Page<Permission> queryPermissionPage(Permission permission) {
        PageHelper.startPage(permission.getPage(),permission.getPageSize());
        return permissionMapper.selectPermissionPageByDomin(permission);
    }

    @Override
    public Page<Permission> queryRolePermissionPage(PermissionQueryModel model) {
        PageHelper.startPage(model.getPage(),model.getPageSize());
        return permissionMapper.selectRolePermissionPageByDomin(model);
    }

    @Override
    public Page<Permission> queryUnboundRolePermissionPage(PermissionQueryModel model) {
        PageHelper.startPage(model.getPage(),model.getPageSize());
        return permissionMapper.selectUnboundRolePermissionPageByDomin(model);
    }
}
