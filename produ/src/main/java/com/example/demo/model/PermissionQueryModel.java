package com.example.demo.model;

import com.example.demo.common.parent.Domin.PageModel;

/**
 * @author Hanyh
 * @create 2018-01-12 11:31
 * @desc
 **/
public class PermissionQueryModel extends PageModel{
    private String name;

    private String url;
    /**
     * 关联资源的角色ID
     */
    private Long roleId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
