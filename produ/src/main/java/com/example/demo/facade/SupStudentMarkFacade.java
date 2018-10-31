package com.example.demo.facade;

import com.example.demo.DTO.query.SupStudentMarkQueryDTO;
import com.example.demo.DTO.result.SupStudentMarkResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;

/**
 * @author Hanyh
 * @create 2018-01-08 14:32
 * @desc
 **/
public interface SupStudentMarkFacade {

    ExecuteResult<PageInfo<SupStudentMarkResultDTO>> queryMarkByDTO(SupStudentMarkQueryDTO supStudentMarkQueryDTO);
}
