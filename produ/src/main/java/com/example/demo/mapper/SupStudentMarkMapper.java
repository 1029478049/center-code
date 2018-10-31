package com.example.demo.mapper;

import com.example.demo.domin.SupStudent;
import com.example.demo.domin.SupStudentMark;
import com.example.demo.domin.SupTeacher;
import com.github.pagehelper.Page;

/**
 * @author Hanyh
 * @create 2018-01-07 21:13
 * @desc
 **/
public interface SupStudentMarkMapper {

    Page<SupStudentMark> selectStuMarkPageByDomin(SupStudentMark supStudentMark);
}
