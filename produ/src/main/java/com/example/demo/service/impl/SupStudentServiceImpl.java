package com.example.demo.service.impl;

import com.example.demo.domin.SupStudent;
import com.example.demo.domin.User;
import com.example.demo.mapper.SupStudentMapper;
import com.example.demo.service.SupStudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hanyh
 * @create 2018-01-07 20:52
 * @desc
 **/
@Service
public class SupStudentServiceImpl implements SupStudentService {

    @Autowired
    private SupStudentMapper supStudentMapper;
    @Override
    public Page<SupStudent> queryStuPage(SupStudent supStudent) {
        PageHelper.startPage(supStudent.getPage(),supStudent.getPageSize());
        return supStudentMapper.selectStudentPageByDomin(supStudent);
    }
}
