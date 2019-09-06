package com.example.demo.facade.Impl;

import com.example.demo.DTO.query.RoleQueryDTO;
import com.example.demo.DTO.result.RoleResultDTO;
import com.example.demo.DTO.result.UserResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.DozerUtil;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.domin.Role;
import com.example.demo.domin.User;
import com.example.demo.facade.AacRoleFacade;
import com.example.demo.model.RoleQueryModel;
import com.example.demo.service.AacRoleService;
import com.github.pagehelper.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Hanyh
 * @create 2018-01-10 11:20
 * @desc
 **/
@Service
public class AacRoleFacadeImpl implements AacRoleFacade {

    private static final Logger logger = LogManager.getLogger(AacRoleFacadeImpl.class);

    @Autowired
    private AacRoleService aacRoleService;

    @Override
    public ExecuteResult<PageInfo<RoleResultDTO>> rolePageResult(RoleQueryDTO roleQueryDTO) {
        ExecuteResult<PageInfo<RoleResultDTO>> result = new ExecuteResult<>();
        try{
            Role role = DozerUtil.map(roleQueryDTO,Role.class);
            Page<Role> page = aacRoleService.queryRolePage(role);
            result.setResult(DozerUtil.mapPage(page.toPageInfo(),RoleResultDTO.class));
            result.setSuccessMessage("查询成功");
            logger.info("查到角色数为<{}>",page.size());
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }

    @Override
    public ExecuteResult<PageInfo<RoleResultDTO>> userRolePageResult(RoleQueryDTO roleQueryDTO) {
        ExecuteResult<PageInfo<RoleResultDTO>> result = new ExecuteResult<>();
        try{
            RoleQueryModel model = DozerUtil.map(roleQueryDTO,RoleQueryModel.class);
            Page<Role> page = aacRoleService.queryUserRolePage(model);
            result.setResult(DozerUtil.mapPage(page.toPageInfo(),RoleResultDTO.class));
            result.setSuccessMessage("查询成功");
            logger.info("查到角色数为<{}>",page.size());
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }

    @Override
    public ExecuteResult<PageInfo<RoleResultDTO>> unboundUserRolePageResult(RoleQueryDTO roleQueryDTO) {
        ExecuteResult<PageInfo<RoleResultDTO>> result = new ExecuteResult<>();
        try{
            RoleQueryModel model = DozerUtil.map(roleQueryDTO,RoleQueryModel.class);
            Page<Role> page = aacRoleService.queryUnboundUserRolePage(model);
            result.setResult(DozerUtil.mapPage(page.toPageInfo(),RoleResultDTO.class));
            result.setSuccessMessage("查询成功");
            logger.info("查到角色数为<{}>",page.size());
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }

    @Override
    public ExecuteResult<String> doImpowerOper(Long uId, List<Long> list) {
        ExecuteResult<String> result = new ExecuteResult<String>();
        try{
            Assert.notNull(uId,"用户ID为空");
            Assert.isTrue(list.size() != 0,"没有一个角色被授权");
            int number = aacRoleService.doImpowerOper(uId,list);
            if(number == 0){
                result.setResult("授权失败");
                return result;
            }
            result.setResult("授权成功");
            result.setSuccessMessage("授权成功");
        }catch (IllegalArgumentException e){
            result.addErrorMessage(e.getMessage());
            logger.error("断言异常，uId:<{}>;list:<{}>",e,uId,list.toString());
        }catch (Exception e){
            result.addErrorMessage(e.getMessage());
            logger.error("系统异常",e);
        }
        return result;
    }

    @Override
    public ExecuteResult<String> relieveImpowerOper(Long uId, List<Long> list) {
        ExecuteResult<String> result = new ExecuteResult<String>();
        try{
            Assert.notNull(uId,"用户ID为空");
            Assert.isTrue(list.size() != 0,"没有一个角色被勾选");
            int number = aacRoleService.cancelImpowerOper(uId,list);
            if(number == 0){
                result.setResult("解除授权失败");
                return result;
            }
            result.setResult("解除授权成功");
            result.setSuccessMessage("解除授权成功");
        }catch (IllegalArgumentException e){
            result.addErrorMessage(e.getMessage());
            logger.error("断言异常<{}>，uId:<{}>;list:<{}>",e,uId,list.toString());
        }catch (Exception e){
            result.addErrorMessage(e.getMessage());
            logger.error("系统异常",e);
        }
        return result;
    }
}
