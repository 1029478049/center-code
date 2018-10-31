package com.example.demo.DTO.result;

import com.example.demo.common.parent.DTO.PageDTO;

import java.util.Date;

/**
 * @author Hanyh
 * @create 2018-01-08 15:58
 * @desc
 **/
public class SupWorkerResultDTO extends PageDTO{
    /**
     * '姓名'
     */
    private String name;
    /**
     * '年龄'
     */
    private Long age;
    /**
     * 工作年龄
     */
    private String workerAge;
    /**
     * 性别
     */
    private String gender;
    /**
     * '最高学历'
     */
    private String maxEducation;
    /**
     * '邮件'
     */
    private String email;
    /**
     * '紧急联系人电话'
     */
    private String emergencyContactPhone;
    /**
     * '紧急联系人'
     */
    private String emergencyContact;
    /**
     * 电话
     */
    private String phone;
    /**
     * 职位
     */
    private String position;
    /**
     * 入职时间
     */
    private Date workTime;
    /**
     * 家庭地址
     */
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getWorkerAge() {
        return workerAge;
    }

    public void setWorkerAge(String workerAge) {
        this.workerAge = workerAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaxEducation() {
        return maxEducation;
    }

    public void setMaxEducation(String maxEducation) {
        this.maxEducation = maxEducation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
