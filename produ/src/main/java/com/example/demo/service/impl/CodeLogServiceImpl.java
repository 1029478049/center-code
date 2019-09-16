package com.example.demo.service.impl;

import com.example.demo.domin.PlatformLog;
import com.example.demo.mapper.PlatformLogMapper;
import com.example.demo.service.CodeLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeLogServiceImpl implements CodeLogService {

    @Autowired
    private PlatformLogMapper platformLogMapper;
    @Override
    public Page<PlatformLog> queryLogsPage(PlatformLog platformLog) {
        PageHelper.startPage(platformLog.getPage(),platformLog.getPageSize());
        return platformLogMapper.selectLogPageByDomin(platformLog);
    }
}
