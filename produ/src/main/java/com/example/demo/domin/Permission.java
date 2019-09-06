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
@Table(name = "u_permission")
public class Permission extends PageModel{
    /**
     * url地址
     */
    @Column(name = "url")
    private String url;
    /**
     * url描述
     */
    @Column(name= "name")
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
