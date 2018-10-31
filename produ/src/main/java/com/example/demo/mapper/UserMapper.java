package com.example.demo.mapper;

import com.example.demo.DTO.result.UserResultDTO;
import com.example.demo.common.parent.Mapper.IMapper;
import com.example.demo.domin.User;
import com.github.pagehelper.Page;

import java.util.List;

public interface UserMapper  extends IMapper<User> {
    /**
     *
     * @param user
     * @return
     */
    List<User> selectUserByDomin(User user);

    Page<User> selectUserPageByDomin(User user);
}