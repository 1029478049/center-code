package com.example.demo.facade;

import com.example.demo.DTO.query.RoleQueryDTO;
import com.example.demo.DTO.result.RoleResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;

import java.util.List;

/**
 * @author Hanyh
 * @create 2018-01-10 11:20
 * @desc
 **/
public interface AacRoleFacade {

    ExecuteResult<PageInfo<RoleResultDTO>> rolePageResult(RoleQueryDTO roleQueryDTO);

    ExecuteResult<PageInfo<RoleResultDTO>> userRolePageResult(RoleQueryDTO roleQueryDTO);

    ExecuteResult<PageInfo<RoleResultDTO>> unboundUserRolePageResult(RoleQueryDTO roleQueryDTO);

    ExecuteResult<String> doImpowerOper(Long uId, List<Long> list);

    ExecuteResult<String> relieveImpowerOper(Long uId, List<Long> list);
}
