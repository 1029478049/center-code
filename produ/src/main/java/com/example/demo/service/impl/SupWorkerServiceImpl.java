package com.example.demo.service.impl;

import com.example.demo.domin.SupWorker;
import com.example.demo.facade.SupWorkerFacade;
import com.example.demo.mapper.SupWorkerMapper;
import com.example.demo.service.SupWorkerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hanyh
 * @create 2018-01-08 16:03
 * @desc
 **/
@Service
public class SupWorkerServiceImpl implements SupWorkerService {

    @Autowired
    private SupWorkerMapper supWorkerMapper;

    @Override
    public Page<SupWorker> queryStuMarkPage(SupWorker supWorker) {
        PageHelper.startPage(supWorker.getPage(),supWorker.getPageSize());
        return supWorkerMapper.selectWorkerPageByDomin(supWorker);
    }
}
