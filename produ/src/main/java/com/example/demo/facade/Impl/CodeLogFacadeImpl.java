package com.example.demo.facade.Impl;

import com.example.demo.DTO.query.PlatformLogQueryDTO;
import com.example.demo.DTO.result.PlatformLogResultDTO;
import com.example.demo.DTO.result.UserResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.DozerUtil;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.domin.PlatformLog;
import com.example.demo.domin.User;
import com.example.demo.facade.CodeLogFacade;
import com.example.demo.service.CodeLogService;
import com.github.pagehelper.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeLogFacadeImpl implements CodeLogFacade {

    private static final Logger logger = LogManager.getLogger(CodeLogFacadeImpl.class);

    @Autowired
    private CodeLogService codeLogService;
    @Override
    public ExecuteResult<PageInfo<PlatformLogResultDTO>> logsListResult(PlatformLogQueryDTO platformLogQueryDTO) {
        ExecuteResult<PageInfo<PlatformLogResultDTO>> result = new ExecuteResult<>();
        try{
            PlatformLog platformLog = DozerUtil.map(platformLogQueryDTO, PlatformLog.class);
            Page<PlatformLog> page = codeLogService.queryLogsPage(platformLog);
            result.setResult(DozerUtil.mapPage(page.toPageInfo(),PlatformLogResultDTO.class));
            result.setSuccessMessage("查询成功");
            logger.info("查到日志数为<{}>",page.size());
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }
}
