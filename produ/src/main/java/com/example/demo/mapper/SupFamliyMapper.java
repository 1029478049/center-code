package com.example.demo.mapper;

import com.example.demo.domin.SupFamliy;
import com.example.demo.domin.SupStudentMark;
import com.github.pagehelper.Page;

/**
 * @author Hanyh
 * @create 2018-01-07 21:50
 * @desc
 **/
public interface SupFamliyMapper {

    Page<SupFamliy> selectFamliyMarkPageByDomin(SupFamliy supFamliy);
}
