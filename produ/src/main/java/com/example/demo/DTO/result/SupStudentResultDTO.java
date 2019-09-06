package com.example.demo.DTO.result;

import com.example.demo.common.parent.DTO.PageDTO;

/**
 * @author Hanyh
 * @create 2018-01-08 10:16
 * @desc
 **/
public class SupStudentResultDTO extends PageDTO{
    /**
     * 中文名字
     */
    private String name;
    /**
     * 英文名字
     */
    private String engName;
    /**
     * 性别；0：女；1：男
     */
    private Long gender;
    /**
     * 年龄
     */
    private Long age;
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
     * 家庭地址
     */
    private String address;
    /**
     * 爸爸电话
     */
    private String fatherPhone;
    /**
     * 妈妈电话
     */
    private String matherPhone;
    /**
     * 邮件
     */
    private String email;
    /**
     * 是否为正式学员，0：正式学员；1：目标招生学员
     */
    private Long isFormal;
    /**
     * 关联工作人员的ID
     */
    private  Long workerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    public String getMatherPhone() {
        return matherPhone;
    }

    public void setMatherPhone(String matherPhone) {
        this.matherPhone = matherPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIsFormal() {
        return isFormal;
    }

    public void setIsFormal(Long isFormal) {
        this.isFormal = isFormal;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }
}
