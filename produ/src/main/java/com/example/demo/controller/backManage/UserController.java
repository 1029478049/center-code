package com.example.demo.controller.backManage;

import com.example.demo.DTO.query.UserQueryDTO;
import com.example.demo.DTO.result.UserResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.facade.AacUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Hanyh
 * @create 2017-12-15 16:24
 * @desc 用户表
 **/
@Controller
@RequestMapping(value = "userPath")
public class UserController {

    @Autowired
    private AacUserFacade aacUserFacade;
/*------------------------------------------QUERY-START--------------------------------------------------*/

    /**
     * 分页查询
     * @param userQueryDTO
     * @return
     */
    @RequestMapping("/queryUser")
    @ResponseBody
    public ExecuteResult<PageInfo<UserResultDTO>> queryUserList(UserQueryDTO userQueryDTO){
        return aacUserFacade.userListResult(userQueryDTO);
    }
/*------------------------------------------QUERY-END--------------------------------------------------*/
/*------------------------------------------deleted-START--------------------------------------------------*/
    @RequestMapping("/deletedUser")
    @ResponseBody
    public ExecuteResult<String> deletedUserById(Long id){
        return aacUserFacade.deletedUserById(id);
    }
/*------------------------------------------deleted-END--------------------------------------------------*/
/*------------------------------------------edit-START--------------------------------------------------*/
    @RequestMapping("toEdit")
    public String toEdit(Long id){
        return "/backManage/user/edit";
    }
    @RequestMapping("doEdit")
    @ResponseBody
    public ExecuteResult<String> doEdit(UserQueryDTO userQueryDTO){
        return aacUserFacade.editUserByDTO(userQueryDTO);
    }
/*------------------------------------------deleted-END--------------------------------------------------*/
/*------------------------------------------add-STARt--------------------------------------------------*/
    @RequestMapping("toAdd")
    public String toAdd(){
        return "/backManage/user/add";
    }
    @RequestMapping("doAdd")
    @ResponseBody
    public ExecuteResult<String> doAdd(UserQueryDTO userQueryDTO){
        return aacUserFacade.addUserByDTO(userQueryDTO);
    }
/*------------------------------------------deleted-END--------------------------------------------------*/
}
