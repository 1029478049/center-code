package com.example.demo.service.impl;

import com.example.demo.domin.SupStudent;
import com.example.demo.domin.SupStudentMark;
import com.example.demo.mapper.SupStudentMarkMapper;
import com.example.demo.service.SupStudentMarkService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hanyh
 * @create 2018-01-08 14:33
 * @desc
 **/
@Service
public class SupStudentMarkServiceImpl implements SupStudentMarkService {

    @Autowired
    private SupStudentMarkMapper supStudentMarkMapper;

    @Override
    public Page<SupStudentMark> queryStuMarkPage(SupStudentMark supStudentMark) {
        PageHelper.startPage(supStudentMark.getPage(),supStudentMark.getPageSize());
        return supStudentMarkMapper.selectStuMarkPageByDomin(supStudentMark);
    }
}
