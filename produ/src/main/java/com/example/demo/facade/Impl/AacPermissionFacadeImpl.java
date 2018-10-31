package com.example.demo.facade.Impl;

import com.example.demo.DTO.query.PermissionQueryDTO;
import com.example.demo.DTO.result.PermissionResultDTO;
import com.example.demo.DTO.result.RoleResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.DozerUtil;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.domin.Permission;
import com.example.demo.domin.Role;
import com.example.demo.facade.AacPermissionFacade;
import com.example.demo.model.PermissionQueryModel;
import com.example.demo.service.AacPermissionService;
import com.github.pagehelper.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hanyh
 * @create 2018-01-10 11:30
 * @desc
 **/
@Service
public class AacPermissionFacadeImpl implements AacPermissionFacade {

    private static final Logger logger = LogManager.getLogger(AacPermissionFacadeImpl.class);
    @Autowired
    private AacPermissionService aacPermissionService;

    @Override
    public ExecuteResult<PageInfo<PermissionResultDTO>> permissionPageResult(PermissionQueryDTO permissionQueryDTO) {
        ExecuteResult<PageInfo<PermissionResultDTO>> result = new ExecuteResult<>();
        try{
            Permission permission = DozerUtil.map(permissionQueryDTO,Permission.class);
            Page<Permission> page = aacPermissionService.queryPermissionPage(permission);
            result.setResult(DozerUtil.mapPage(page.toPageInfo(),PermissionResultDTO.class));
            result.setSuccessMessage("查询成功");
            logger.info("查到资源数为<{}>",page.size());
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }

    @Override
    public ExecuteResult<PageInfo<PermissionResultDTO>> rolePermPageResult(PermissionQueryDTO permissionQueryDTO) {
        ExecuteResult<PageInfo<PermissionResultDTO>> result = new ExecuteResult<>();
        try{
            PermissionQueryModel model = DozerUtil.map(permissionQueryDTO,PermissionQueryModel.class);
            Page<Permission> page = aacPermissionService.queryRolePermissionPage(model);
            result.setResult(DozerUtil.mapPage(page.toPageInfo(),PermissionResultDTO.class));
            result.setSuccessMessage("查询成功");
            logger.info("查到资源数为<{}>",page.size());
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }

    @Override
    public ExecuteResult<PageInfo<PermissionResultDTO>> unboundrolePermPageResult(PermissionQueryDTO permissionQueryDTO) {
        ExecuteResult<PageInfo<PermissionResultDTO>> result = new ExecuteResult<>();
        try{
            PermissionQueryModel model = DozerUtil.map(permissionQueryDTO,PermissionQueryModel.class);
            Page<Permission> page = aacPermissionService.queryUnboundRolePermissionPage(model);
            result.setResult(DozerUtil.mapPage(page.toPageInfo(),PermissionResultDTO.class));
            result.setSuccessMessage("查询成功");
            logger.info("查到资源数为<{}>",page.size());
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }
}
