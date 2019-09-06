package com.example.demo.domin;

import com.example.demo.common.parent.Domin.PageModel;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author Hanyh
 * @create 2018-01-07 20:10
 * @desc 学生
 **/
@Table(name = "sup_student")
public class SupStudent extends PageModel {
    /**
     * 中文名字
     */
    @Column(name = "name")
    private String name;
    /**
     * 英文名字
     */
    @Column(name = "eng_name")
    private String engName;
    /**
     * 性别；0：女；1：男
     */
    @Column(name = "gender")
    private Long gender;
    /**
     * 年龄
     */
    @Column(name = "age")
    private Long age;
    /**
     * 小学
     */
    @Column(name = "primary_school")
    private String primarySchool;
    /**
     * 初中
     */
    @Column(name = "middle_school")
    private String middleSchool;
    /**
     * 高中
     */
    @Column(name = "high_school")
    private String highSchool;
    /**
     * 家庭地址
     */
    @Column(name = "address")
    private String address;
    /**
     * 爸爸电话
     */
    @Column(name = "father_phone")
    private String fatherPhone;
    /**
     * 妈妈电话
     */
    @Column(name = "mather_phone")
    private String matherPhone;
    /**
     * 邮件
     */
    @Column(name = "email")
    private String email;
    /**
     * 是否为正式学员，0：正式学员；1：目标招生学员
     */
    @Column(name = "is_formal")
    private Long isFormal;
    /**
     *
     */
    @Column(name = "worker_id")
    private Long workerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "SupStudent{" +
                "name='" + name + '\'' +
                ", engName='" + engName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", primarySchool='" + primarySchool + '\'' +
                ", middleSchool='" + middleSchool + '\'' +
                ", highSchool='" + highSchool + '\'' +
                ", address='" + address + '\'' +
                ", fatherPhone='" + fatherPhone + '\'' +
                ", matherPhone='" + matherPhone + '\'' +
                ", email='" + email + '\'' +
                ", isFormal='" + isFormal + '\'' +
                ", workerId='" + workerId + '\'' +
                '}';
    }
}
