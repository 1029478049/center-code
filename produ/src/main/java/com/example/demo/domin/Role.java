package com.example.demo.domin;

import com.example.demo.common.parent.Domin.BaseDomin;
import com.example.demo.common.parent.Domin.PageModel;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author Hanyh
 * @create 2017-12-11 18:58
 * @desc
 **/
@Table(name = "u_role")
public class Role extends PageModel{
    /**
     *角色名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 角色类型
     */
    @Column(name = "type")
    private String type;

    @Column(name = "role_desc")
    private String roleDesc;

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
}
