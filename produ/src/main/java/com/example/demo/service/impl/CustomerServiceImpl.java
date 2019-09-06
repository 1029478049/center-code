package com.example.demo.service.impl;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.CustomerModel;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hanyh
 * @create 2017-11-20 14:19
 * @desc
 **/
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<CustomerDTO> queryALLByDTO(CustomerModel model) {
        return customerMapper.selsectAll(model);
    }
}
