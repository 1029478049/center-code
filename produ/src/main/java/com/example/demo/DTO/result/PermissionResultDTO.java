package com.example.demo.DTO.result;

import com.example.demo.common.parent.DTO.PageDTO;

/**
 * @author Hanyh
 * @create 2018-01-10 11:36
 * @desc
 **/
public class PermissionResultDTO extends PageDTO{

    private String name;

    private String url;

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
