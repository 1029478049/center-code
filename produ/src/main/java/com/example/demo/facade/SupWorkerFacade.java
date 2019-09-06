package com.example.demo.facade;

import com.example.demo.DTO.query.SupWorkerQueryDTO;
import com.example.demo.DTO.result.SupWorkerResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;

/**
 * @author Hanyh
 * @create 2018-01-08 16:02
 * @desc
 **/
public interface SupWorkerFacade {

    ExecuteResult<PageInfo<SupWorkerResultDTO>> workListResult(SupWorkerQueryDTO supWorkerQueryDTO);
}
