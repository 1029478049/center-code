package com.example.demo.DTO.query;

import com.example.demo.common.parent.DTO.PageDTO;

import javax.persistence.Column;

/**
 * @author Hanyh
 * @create 2018-01-08 9:43
 * @desc
 **/
public class SupStudentQueryDTO extends PageDTO{
    /**
     * 中文名称
     */
    private String name;
    /**
     * 性别；0：女；1：男
     */
    private Long gender;
    /**
     * 邮件
     */
    private String email;
    /**
     * 小学
     */
    private String primarySchool;
    /**
     * 初中
     */
    private String middleSchool;
    /**
     * 高中
     */
    private String highSchool;
    /**
     * 关联工作人员的ID
     */
    private  Long workerId;
    /**
     * 是否为正式学员，0：正式学员；1：目标招生学员
     */
    private Long isFormal;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimarySchool() {
        return primarySchool;
    }

    public void setPrimarySchool(String primarySchool) {
        this.primarySchool = primarySchool;
    }

    public String getMiddleSchool() {
        return middleSchool;
    }

    public void setMiddleSchool(String middleSchool) {
        this.middleSchool = middleSchool;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public Long getIsFormal() {
        return isFormal;
    }

    public void setIsFormal(Long isFormal) {
        this.isFormal = isFormal;
    }
}
