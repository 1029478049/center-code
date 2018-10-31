package com.example.demo.service;

import com.example.demo.domin.SupStudent;
import com.example.demo.domin.SupStudentMark;
import com.github.pagehelper.Page;

/**
 * @author Hanyh
 * @create 2018-01-08 14:33
 * @desc
 **/
public interface SupStudentMarkService {

    Page<SupStudentMark> queryStuMarkPage(SupStudentMark supStudentMark);
}
