package com.example.demo.service;

import com.example.demo.domin.SupStudent;
import com.example.demo.domin.User;
import com.github.pagehelper.Page;

/**
 * @author Hanyh
 * @create 2018-01-07 20:51
 * @desc
 **/
public interface SupStudentService {

    Page<SupStudent> queryStuPage(SupStudent supStudent);
}
