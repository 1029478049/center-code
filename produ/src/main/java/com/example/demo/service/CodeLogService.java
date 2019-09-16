package com.example.demo.service;

import com.example.demo.domin.PlatformLog;
import com.github.pagehelper.Page;

public interface CodeLogService {

    Page<PlatformLog> queryLogsPage(PlatformLog user);
}
