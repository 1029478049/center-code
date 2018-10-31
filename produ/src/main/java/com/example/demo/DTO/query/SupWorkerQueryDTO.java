package com.example.demo.DTO.query;

import com.example.demo.common.parent.DTO.PageDTO;

/**
 * @author Hanyh
 * @create 2018-01-08 16:00
 * @desc
 **/
public class SupWorkerQueryDTO extends PageDTO{
    /**
     * '姓名'
     */
    private String name;
    /**
     * 职位
     */
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
