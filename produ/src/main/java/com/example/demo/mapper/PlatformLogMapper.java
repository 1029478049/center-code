package com.example.demo.mapper;

import com.example.demo.common.parent.Mapper.IMapper;
import com.example.demo.domin.PlatformLog;
import com.github.pagehelper.Page;

public interface PlatformLogMapper extends IMapper<PlatformLog> {

    Page<PlatformLog> selectLogPageByDomin(PlatformLog platformLog);
}
