package com.example.demo.service;

import com.example.demo.domin.SupWorker;
import com.github.pagehelper.Page;

/**
 * @author Hanyh
 * @create 2018-01-08 16:03
 * @desc
 **/
public interface SupWorkerService {

    Page<SupWorker> queryStuMarkPage(SupWorker supWorker);
}
