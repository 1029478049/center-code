package com.example.demo.DTO.query;

import com.example.demo.common.parent.DTO.PageDTO;

/**
 * @author Hanyh
 * @create 2018-01-10 11:37
 * @desc
 **/
public class PermissionQueryDTO extends PageDTO{
    private String name;

    private String url;
    /**
     * 关联资源的角色ID
     */
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

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

    @Override
    public String toString() {
        return "PermissionResultDTO{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
