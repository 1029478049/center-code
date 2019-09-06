package com.example.demo.mapper;

import com.example.demo.domin.SupStudent;
import com.github.pagehelper.Page;

/**
 * @author Hanyh
 * @create 2018-01-07 20:23
 * @desc
 **/
public interface SupStudentMapper {

    Page<SupStudent> selectStudentPageByDomin(SupStudent supStudent);
}
