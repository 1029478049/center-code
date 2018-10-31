package com.example.demo.service;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.model.CustomerModel;

import java.util.List;

/**
 * @author Hanyh
 * @create 2017-11-20 14:18
 * @desc
 **/
public interface CustomerService {

    List<CustomerDTO> queryALLByDTO(CustomerModel model);
}
