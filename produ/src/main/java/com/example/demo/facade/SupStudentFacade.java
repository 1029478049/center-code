package com.example.demo.facade;

import com.example.demo.DTO.query.SupStudentQueryDTO;
import com.example.demo.DTO.result.SupStudentResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;

/**
 * @author Hanyh
 * @create 2018-01-07 20:53
 * @desc
 **/
public interface SupStudentFacade {

    ExecuteResult<PageInfo<SupStudentResultDTO>> stuListResult(SupStudentQueryDTO supStudentQueryDTO);
}
