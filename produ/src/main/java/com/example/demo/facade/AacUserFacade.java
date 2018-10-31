package com.example.demo.facade;

import com.example.demo.DTO.query.UserQueryDTO;
import com.example.demo.DTO.result.UserResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.domin.User;

import java.util.List;
import java.util.Map;

/**
 * @author Hanyh
 * @create 2017-12-11 18:37
 * @desc
 **/
public interface AacUserFacade {
    /**
     * 用于查询
     * 根据 ${param} 查询
     * @param userQueryDTO
     * @return UserResultDTO
     */
    ExecuteResult<PageInfo<UserResultDTO>> userListResult(UserQueryDTO userQueryDTO);

    /**
     * 用于登陆
     *  根据map查询
     * @param map
     * @return
     */
    ExecuteResult<List<User>> queryUserByMap(Map<String, Object> map);

    /**
     * 通过Id删除用户
     * @param id
     * @return
     */
    ExecuteResult<String> deletedUserById(Long id);

    /**
     * 通过对象修改用户
     * @param userQueryDTO
     * @return
     */
    ExecuteResult<String> editUserByDTO(UserQueryDTO userQueryDTO);
    /**
     * 通过对象增加用户
     * @param userQueryDTO
     * @return
     */
    ExecuteResult<String> addUserByDTO(UserQueryDTO userQueryDTO);
}
