package com.example.demo.facade.Impl;

import com.example.demo.DTO.query.SupWorkerQueryDTO;
import com.example.demo.DTO.result.SupWorkerResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.DozerUtil;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.domin.SupWorker;
import com.example.demo.facade.SupWorkerFacade;
import com.example.demo.service.SupWorkerService;
import com.github.pagehelper.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hanyh
 * @create 2018-01-08 16:02
 * @desc
 **/
@Service
public class SupWorkerFacadeImpl implements SupWorkerFacade{

    private static final Logger logger = LogManager.getLogger(SupWorkerFacadeImpl.class);
    @Autowired
    private SupWorkerService supWorkerService;

    @Override
    public ExecuteResult<PageInfo<SupWorkerResultDTO>> workListResult(SupWorkerQueryDTO supWorkerQueryDTO) {
        ExecuteResult<PageInfo<SupWorkerResultDTO>> result = new ExecuteResult<>();
        try{
            SupWorker supWorker = DozerUtil.map(supWorkerQueryDTO,SupWorker.class);
            Page<SupWorker> page = supWorkerService.queryStuMarkPage(supWorker);
            result.setResult(DozerUtil.mapPage(page.toPageInfo(),SupWorkerResultDTO.class));
            result.setSuccessMessage("查询成功");
            logger.info("查到用户数为<{}>",page.size());
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }
}
