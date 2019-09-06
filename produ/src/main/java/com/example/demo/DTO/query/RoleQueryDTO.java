package com.example.demo.DTO.query;

import com.example.demo.common.parent.DTO.PageDTO;

/**
 * @author Hanyh
 * @create 2018-01-10 11:27
 * @desc
 **/
public class RoleQueryDTO extends PageDTO{
    /**
     *角色名称
     */
    private String name;
    /**
     * 角色类型
     */
    private String type;
    /**
     * 角色描述
     */
    private String roleDesc;
    /**
     * 用户id通过u_user_role来查role信息
     */
    private Long uId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    @Override
    public String toString() {
        return "RoleResultDTO{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", uId='" + uId + '\'' +
                '}';
    }
}
