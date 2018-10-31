package com.example.demo.mapper;

import com.example.demo.domin.SupStudentMark;
import com.example.demo.domin.SupTeacher;
import com.github.pagehelper.Page;

/**
 * @author Hanyh
 * @create 2018-01-07 22:13
 * @desc
 **/
public interface SupTeacherMapper {

    Page<SupTeacher> selectTeacherPageByDomin(SupTeacher supTeacher);
}
