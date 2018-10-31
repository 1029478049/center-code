package com.example.demo.domin;

import com.example.demo.common.parent.Domin.BaseDomin;
import com.example.demo.common.parent.Domin.PageModel;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Hanyh
 * @create 20@Column(name = "")8-0@Column(name = "")-07 2@Column(name = ""):58
 * @desc
 **/
@Table(name = "sup_worker")
public class SupWorker extends PageModel {
    /**
     * '姓名'
     */
    @Column(name = "name")
    private String name;
    /**
     * '年龄'
     */
    @Column(name = "age")
    private Long age;
    /**
     * 工作年龄
     */
    @Column(name = "worker_age")
    private String workerAge;
    /**
     * 性别
     */
    @Column(name = "gender")
    private String gender;
    /**
     * '最高学历'
     */
    @Column(name = "max_education")
    private String maxEducation;
    /**
     * '邮件'
     */
    @Column(name = "email")
    private String email;
    /**
     * '紧急联系人电话'
     */
    @Column(name = "emergency_contact_phone")
    private String emergencyContactPhone;
    /**
     * '紧急联系人'
     */
    @Column(name = "emergency_contact")
    private String emergencyContact;
    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 职位
     */
    @Column(name = "position")
    private String position;
    /**
     * 入职时间
     */
    @Column(name = "work_time")
    private Date workTime;
    /**
     * 家庭地址
     */
    @Column(name = "address")
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

    @Override
    public String toString() {
        return "SupWorker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", workerAge='" + workerAge + '\'' +
                ", gender='" + gender + '\'' +
                ", maxEducation='" + maxEducation + '\'' +
                ", email='" + email + '\'' +
                ", emergencyContactPhone='" + emergencyContactPhone + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                ", workTime=" + workTime +
                ", address='" + address + '\'' +
                '}';
    }
}
