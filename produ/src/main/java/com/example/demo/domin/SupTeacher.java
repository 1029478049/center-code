package com.example.demo.domin;

import com.example.demo.common.parent.Domin.BaseDomin;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author Hanyh
 * @create 2018-01-07 21:58
 * @desc
 **/
@Table(name = "sup_teacher")
public class SupTeacher extends BaseDomin {
    /**
     * 学生表关系id
     */
    @Column(name = "stu_id")
    private Long stuId;
    /**
     * '老师名字'
     */
    @Column(name = "teacher_name")
    private String teacherName;
    /**
     * '老师年龄'
     */
    @Column(name = "age")
    private Long age;
    /**
     * '教学年龄'
     */
    @Column(name = "teacher_age")
    private Long teacherAge;
    /**
     * 性别；0：女；1：男
     */
    @Column(name = "gender")
    private Long gender;
    /**
     * 教师职责；0:任课老师；1：班主
     */
    @Column(name = "teacher_res")
    private String teacherRes;
    /**
     * '最高学历'
     */
    @Column(name = "max_education")
    private String maxEducation;
    /**
     * '现教科目'
     */
    @Column(name = "subject")
    private String subject;
    /**
     * '联系电话'
     */
    @Column(name = "phone")
    private String phone;
    /**
     * '是否在校教学'
     */
    @Column(name = "is_teach")
    private String isTeach;
    /**
     * '学校地址'
     */
    @Column(name = "school_address")
    private String schoolAddress;
    /**
     * '家庭地址'
     */
    @Column(name = "address")
    private String address;
    /**
     * '最高学历毕业学校'
     */
    @Column(name = "max_education_name")
    private String maxEducationName;
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

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }


    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public String getTeacherRes() {
        return teacherRes;
    }

    public void setTeacherRes(String teacherRes) {
        this.teacherRes = teacherRes;
    }

    public String getMaxEducation() {
        return maxEducation;
    }

    public void setMaxEducation(String maxEducation) {
        this.maxEducation = maxEducation;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
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

    public Long getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Long teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getIsTeach() {
        return isTeach;
    }

    public void setIsTeach(String isTeach) {
        this.isTeach = isTeach;
    }

    public String getMaxEducationName() {
        return maxEducationName;
    }

    public void setMaxEducationName(String maxEducationName) {
        this.maxEducationName = maxEducationName;
    }

    @Override
    public String toString() {
        return "SupTeacher{" +
                "stuId=" + stuId +
                ", teacherName='" + teacherName + '\'' +
                ", age=" + age +
                ", teacherAge=" + teacherAge +
                ", gender=" + gender +
                ", teacherRes='" + teacherRes + '\'' +
                ", maxEducation='" + maxEducation + '\'' +
                ", subject='" + subject + '\'' +
                ", phone='" + phone + '\'' +
                ", isTeach='" + isTeach + '\'' +
                ", schoolAddress='" + schoolAddress + '\'' +
                ", address='" + address + '\'' +
                ", maxEducationName='" + maxEducationName + '\'' +
                ", email='" + email + '\'' +
                ", emergencyContactPhone='" + emergencyContactPhone + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                '}';
    }
}
