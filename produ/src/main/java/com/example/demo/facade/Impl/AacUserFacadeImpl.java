package com.example.demo.facade.Impl;

import com.example.demo.DTO.query.UserQueryDTO;
import com.example.demo.DTO.result.UserResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.BeanUtil;
import com.example.demo.common.util.DozerUtil;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.domin.User;
import com.example.demo.facade.AacUserFacade;
import com.example.demo.service.AacUserService;
import com.github.pagehelper.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Hanyh
 * @create 2017-12-11 18:40
 * @desc
 **/
@Service
public class AacUserFacadeImpl implements AacUserFacade{

    private static final Logger logger = LogManager.getLogger(AacUserFacadeImpl.class);
    @Autowired
    private AacUserService aacUserService;

    @Override
    public ExecuteResult<PageInfo<UserResultDTO>> userListResult(UserQueryDTO userQueryDTO) {
        ExecuteResult<PageInfo<UserResultDTO>> result = new ExecuteResult<>();
        try{
            User user = DozerUtil.map(userQueryDTO,User.class);
            Page<User> page = aacUserService.queryUserPage(user);
            result.setResult(DozerUtil.mapPage(page.toPageInfo(),UserResultDTO.class));
            result.setSuccessMessage("查询成功");
            logger.info("查到用户数为<{}>",page.size());
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }

    @Override
    public ExecuteResult<List<User>> queryUserByMap(Map<String, Object> map) {
        ExecuteResult<List<User>> result = new ExecuteResult<>();
        if(map.get("username") == null){
            logger.info("[userName:]<{}>",map.get("username"));
            result.addErrorMessage("用户名或密码为空");
            return result;
        }
        try {
            User user = new User();
            user.setUserName((String)map.get("username"));
            //user.setPassword((String)map.get("password"));
            List<User> list = aacUserService.queryUserList(user);
            result.setResult(list);
            result.setSuccessMessage("查询成功");
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }

    @Override
    public ExecuteResult<String> deletedUserById(Long id) {
        ExecuteResult<String> result = new ExecuteResult<String>();
        if(BeanUtil.isEmpty(id)){
            result.addErrorMessage("传入Id为空");
            logger.info("传入Id为空");
            return result;
        }
        try {
            User user = aacUserService.queryById(id);
            aacUserService.remove(user);
            result.setSuccessMessage("通过ID:["+id+"]删除成功");
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }

    @Override
    public ExecuteResult<String> editUserByDTO(UserQueryDTO userQueryDTO) {
        ExecuteResult<String> result = new ExecuteResult<String>();
        try {
            User user = DozerUtil.map(userQueryDTO, User.class);
            aacUserService.updateById(user);
            result.setSuccessMessage("更新用户成功");
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }

    @Override
    public ExecuteResult<String> addUserByDTO(UserQueryDTO userQueryDTO) {
        ExecuteResult<String> result = new ExecuteResult<String>();
        try {
            User user = DozerUtil.map(userQueryDTO,User.class);
            aacUserService.add(user);
            result.setSuccessMessage("增加用户成功");
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }
}
