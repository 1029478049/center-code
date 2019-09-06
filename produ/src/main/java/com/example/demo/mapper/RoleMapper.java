package com.example.demo.mapper;

import com.example.demo.domin.Role;
import com.example.demo.model.RoleQueryModel;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Hanyh
 * @create 2018-01-10 11:01
 * @desc
 **/
public interface RoleMapper {

    Page<Role> selectRolePageByDomin(Role role);

    Page<Role> selectUserRolePageByDomin(RoleQueryModel model);

    Page<Role> selectUnboundUserRolePageByDomin(RoleQueryModel model);

    int insertUserRole(@Param(value = "uId") Long uId,@Param(value = "rIds") List<Long> rIds);

    int deletedUserRole(@Param(value = "uId")Long uId, @Param(value = "rIds")List<Long> rIds);
}
