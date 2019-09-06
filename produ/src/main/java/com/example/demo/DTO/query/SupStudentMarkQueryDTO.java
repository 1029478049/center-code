package com.example.demo.DTO.query;

import com.example.demo.common.parent.DTO.PageDTO;

/**
 * @author Hanyh
 * @create 2018-01-08 14:30
 * @desc
 **/
public class SupStudentMarkQueryDTO extends PageDTO{

    /**
     * 学生表关系id
     */
    private  Long stuId;
    /**
     * 考试类别,0:周考；1：月考；2：期末考试；3：中考；4高考
     */
    private  Long examType;
    /**
     * 考试排名
     */
    private  String examRank;

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

    public Long getStuId() {
        return stuId;
    }

    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }
}
