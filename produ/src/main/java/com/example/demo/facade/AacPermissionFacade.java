package com.example.demo.facade;

import com.example.demo.DTO.query.PermissionQueryDTO;
import com.example.demo.DTO.result.PermissionResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;

/**
 * @author Hanyh
 * @create 2018-01-10 11:30
 * @desc
 **/
public interface AacPermissionFacade {

    ExecuteResult<PageInfo<PermissionResultDTO>> permissionPageResult(PermissionQueryDTO permissionQueryDTO);

    ExecuteResult<PageInfo<PermissionResultDTO>> rolePermPageResult(PermissionQueryDTO permissionQueryDTO);

    ExecuteResult<PageInfo<PermissionResultDTO>> unboundrolePermPageResult(PermissionQueryDTO permissionQueryDTO);
}
