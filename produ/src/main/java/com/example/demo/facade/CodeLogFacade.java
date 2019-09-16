package com.example.demo.facade;

import com.example.demo.DTO.query.PlatformLogQueryDTO;
import com.example.demo.DTO.result.PlatformLogResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;

public interface CodeLogFacade {

    ExecuteResult<PageInfo<PlatformLogResultDTO>> logsListResult(PlatformLogQueryDTO platformLogQueryDTO);
}
