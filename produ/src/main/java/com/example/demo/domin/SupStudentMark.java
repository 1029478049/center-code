package com.example.demo.domin;

import com.example.demo.common.parent.Domin.PageModel;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Hanyh
 * @create 2018-01-07 21:00
 * @desc
 **/
@Table(name = "sup_student_mark")
public class SupStudentMark extends PageModel{
    /**
     * 学生表关系id
     */
    @Column(name = "stu_id")
    private  Long stuId;
    /**
     * 数学成绩
     */
    @Column(name = "math")
    private  String math;
    /**
     * 语文成绩
     */
    @Column(name = "chinese")
    private  String chinese;
    /**
     * 英语成绩
     */
    @Column(name = "english")
    private  String english;
    /**
     * 物理成绩
     */
    @Column(name = "physics")
    private  String physics;
    /**
     * 化学成绩
     */
    @Column(name = "chemistry")
    private  String chemistry;
    /**
     * 生物成绩
     */
    @Column(name = "biology")
    private  String biology;
    /**
     * 体育成绩
     */
    @Column(name = "sports")
    private  String sports;
    /**
     * 政治成绩
     */
    @Column(name = "politics")
    private  String politics;
    /**
     * 地理成绩
     */
    @Column(name = "geography")
    private  String geography;
    /**
     * 考试时间
     */
    @Column(name = "exam_time")
    private Date examTime;
    /**
     * 考试类别,0:周考；1：月考；2：期末考试；3：中考；4高考
     */
    @Column(name = "exam_type")
    private  Long examType;
    /**
     * 考试排名
     */
    @Column(name = "exam_rank")
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

    @Override
    public String toString() {
        return "SupStudentMark{" +
                "stuId=" + stuId +
                ", math='" + math + '\'' +
                ", chinese='" + chinese + '\'' +
                ", english='" + english + '\'' +
                ", physics='" + physics + '\'' +
                ", chemistry='" + chemistry + '\'' +
                ", biology='" + biology + '\'' +
                ", sports='" + sports + '\'' +
                ", politics='" + politics + '\'' +
                ", geography='" + geography + '\'' +
                ", examTime=" + examTime +
                ", examType=" + examType +
                ", examRank='" + examRank + '\'' +
                '}';
    }
}
