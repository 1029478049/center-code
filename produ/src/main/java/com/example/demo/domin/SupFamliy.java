package com.example.demo.domin;

import com.example.demo.common.parent.Domin.PageModel;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author Hanyh
 * @create 2018-01-07 21:40
 * @desc
 **/
@Table(name = "sup_famliy")
public class SupFamliy extends PageModel{
    /**
     * 学生表关系id
     */
    @Column(name = "stu_id")
    private Long stuId;
    /**
     * 爸爸名字
     */
    @Column(name = "father_name")
    private String fatherName;
    /**
     * 爸爸电话
     */
    @Column(name = "father_phone")
    private String fatherPhone;
    /**
     *爸爸年龄
     */
    @Column(name = "father_age")
            private Long fatherAge;
    /**
     *爸爸职业
     */
    @Column(name = "father_work")
            private String fatherWork;
    /**
     *爸爸受教育程度,0:小学；1：初中；2：高中；3：大学；4：研究生；5博士
     */
    @Column(name = "father_schooling")
    private String fatherSchooling;
    /**
     *妈妈名字
     */
    @Column(name = "mather_name")
    private String matherName;
    /**
     *妈妈电话
     */
    @Column(name = "mather_phone")
    private String matherPhone;
    /**
     *妈妈年龄
     */
    @Column(name = "mather_age")
    private Long matherAge;
    /**
     *妈妈职业
     */
    @Column(name = "mather_work")
            private String matherWork;
    /**
     *妈妈受教育程度,0:小学；1：初中；2：高中；3：大学；4：研究生；5博士
     */
    @Column(name = "mather_schooling")
    private String matherSchooling;
    /**
     *家庭地址
     */
    @Column(name = "address")
    private String address;
    /**
     *紧急联系人电话
     */
    @Column(name = "emergency_contact_phone")
    private String emergencyContactPhone;
    /**
     *紧急联系人
     */
    @Column(name = "emergency_contact")
            private String emergencyContact;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherPhone() {
        return fatherPhone;
    }

    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    public Long getFatherAge() {
        return fatherAge;
    }

    public void setFatherAge(Long fatherAge) {
        this.fatherAge = fatherAge;
    }

    public String getFatherWork() {
        return fatherWork;
    }

    public void setFatherWork(String fatherWork) {
        this.fatherWork = fatherWork;
    }

    public String getFatherSchooling() {
        return fatherSchooling;
    }

    public void setFatherSchooling(String fatherSchooling) {
        this.fatherSchooling = fatherSchooling;
    }

    public String getMatherName() {
        return matherName;
    }

    public void setMatherName(String matherName) {
        this.matherName = matherName;
    }

    public String getMatherPhone() {
        return matherPhone;
    }

    public void setMatherPhone(String matherPhone) {
        this.matherPhone = matherPhone;
    }

    public Long getMatherAge() {
        return matherAge;
    }

    public void setMatherAge(Long matherAge) {
        this.matherAge = matherAge;
    }

    public String getMatherWork() {
        return matherWork;
    }

    public void setMatherWork(String matherWork) {
        this.matherWork = matherWork;
    }

    public String getMatherSchooling() {
        return matherSchooling;
    }

    public void setMatherSchooling(String matherSchooling) {
        this.matherSchooling = matherSchooling;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "SupFamliy{" +
                "stuId=" + stuId +
                ", fatherName='" + fatherName + '\'' +
                ", fatherPhone='" + fatherPhone + '\'' +
                ", fatherAge='" + fatherAge + '\'' +
                ", fatherWork='" + fatherWork + '\'' +
                ", fatherSchooling='" + fatherSchooling + '\'' +
                ", matherName='" + matherName + '\'' +
                ", matherPhone='" + matherPhone + '\'' +
                ", matherAge='" + matherAge + '\'' +
                ", matherWork='" + matherWork + '\'' +
                ", matherSchooling='" + matherSchooling + '\'' +
                ", address='" + address + '\'' +
                ", emergencyContactPhone='" + emergencyContactPhone + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                '}';
    }
}
