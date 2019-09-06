package com.example.demo.service;

import com.example.demo.domin.Permission;
import com.example.demo.model.PermissionQueryModel;
import com.github.pagehelper.Page;

/**
 * @author Hanyh
 * @create 2018-01-10 11:31
 * @desc
 **/
public interface AacPermissionService {

    Page<Permission> queryPermissionPage(Permission permission);

    Page<Permission> queryRolePermissionPage(PermissionQueryModel model);

    Page<Permission> queryUnboundRolePermissionPage(PermissionQueryModel model);
}
