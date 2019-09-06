package com.example.demo.DTO.result;

import com.example.demo.common.parent.DTO.PageDTO;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author Hanyh
 * @create 2018-01-08 14:25
 * @desc
 **/
public class SupStudentMarkResultDTO extends PageDTO{
    /**
     * 学生表关系id
     */
    private  Long stuId;
    /**
     * 数学成绩
     */
    private  String math;
    /**
     * 语文成绩
     */
    private  String chinese;
    /**
     * 英语成绩
     */
    private  String english;
    /**
     * 物理成绩
     */
    private  String physics;
    /**
     * 化学成绩
     */
    private  String chemistry;
    /**
     * 生物成绩
     */
    private  String biology;
    /**
     * 体育成绩
     */
    private  String sports;
    /**
     * 政治成绩
     */
    private  String politics;
    /**
     * 地理成绩
     */
    private  String geography;
    /**
     * 考试时间
     */
    private Date examTime;
    /**
     * 考试类别,0:周考；1：月考；2：期末考试；3：中考；4高考
     */
    private  Long examType;
    /**
     * 考试排名
     */
    private  String examRank;

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    public String getMath() {
        return math;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getPhysics() {
        return physics;
    }

    public void setPhysics(String physics) {
        this.physics = physics;
    }

    public String getChemistry() {
        return chemistry;
    }

    public void setChemistry(String chemistry) {
        this.chemistry = chemistry;
    }

    public String getBiology() {
        return biology;
    }

    public void setBiology(String biology) {
        this.biology = biology;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public Long getExamType() {
        return examType;
    }

    public void setExamType(Long examType) {
        this.examType = examType;
    }

    public String getExamRank() {
        return examRank;
    }

    public void setExamRank(String examRank) {
        this.examRank = examRank;
    }
}
