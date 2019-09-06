package com.example.demo.mapper;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.model.CustomerModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hanyh
 * @create 2017-11-20 14:37
 * @desc
 **/
@Service
public interface CustomerMapper {

    public List<CustomerDTO> selsectAll(CustomerModel model);
}
