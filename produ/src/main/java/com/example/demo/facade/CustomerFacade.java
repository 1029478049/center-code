package com.example.demo.facade;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.common.util.ExecuteResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hanyh
 * @create 2017-11-20 14:21
 * @desc
 **/
public interface CustomerFacade {

    public ExecuteResult<List<CustomerDTO>> queryAllByDTO(CustomerDTO customerDTO);

    public List<CustomerDTO> queryByDTO(CustomerDTO customerDTO);
}
