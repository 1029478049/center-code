package com.example.demo.mapper;

import com.example.demo.domin.Permission;
import com.example.demo.model.PermissionQueryModel;
import com.github.pagehelper.Page;

/**
 * @author Hanyh
 * @create 2018-01-10 11:02
 * @desc
 **/
public interface PermissionMapper {

    Page<Permission> selectPermissionPageByDomin(Permission role);

    Page<Permission> selectRolePermissionPageByDomin(PermissionQueryModel model);

    Page<Permission> selectUnboundRolePermissionPageByDomin(PermissionQueryModel model);
}
