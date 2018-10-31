package com.example.demo.service;

import com.example.demo.domin.Role;
import com.example.demo.model.RoleQueryModel;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author Hanyh
 * @create 2018-01-10 11:21
 * @desc
 **/
public interface AacRoleService {

    Page<Role> queryRolePage(Role role);

    Page<Role> queryUserRolePage(RoleQueryModel model);

    Page<Role> queryUnboundUserRolePage(RoleQueryModel model);

    int doImpowerOper(Long uId, List<Long> list);

    int cancelImpowerOper(Long uId, List<Long> list);
}
