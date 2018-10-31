package com.example.demo.mapper;

import com.example.demo.domin.SupTeacher;
import com.example.demo.domin.SupWorker;
import com.github.pagehelper.Page;

/**
 * @author Hanyh
 * @create 2018-01-07 22:25
 * @desc
 **/
public interface SupWorkerMapper {

    Page<SupWorker> selectWorkerPageByDomin(SupWorker supWorker);
}
