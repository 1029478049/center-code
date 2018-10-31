package com.example.demo.facade.Impl;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.facade.CustomerFacade;
import com.example.demo.model.CustomerModel;
import com.example.demo.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hanyh
 * @create 2017-11-20 14:21
 * @desc
 **/
@Service
public class CustomerFacadeImpl implements CustomerFacade {

    private static final Logger logger = LogManager.getLogger(CustomerFacadeImpl.class);
    @Autowired
    private CustomerService customerService;
    @Override
    public ExecuteResult<List<CustomerDTO>> queryAllByDTO(CustomerDTO customerDTO) {
        ExecuteResult<List<CustomerDTO>> result = new ExecuteResult<List<CustomerDTO>>();
        List<CustomerDTO> list = null;
        try{
            CustomerModel model = new CustomerModel();
            list = customerService.queryALLByDTO(model);
            result.setResult(list);
        }catch (Exception e){
            logger.error("系统异常...");
        }
        return result;
    }

    @Override
    public List<CustomerDTO> queryByDTO(CustomerDTO customerDTO) {
        List<CustomerDTO> result = new ArrayList<CustomerDTO>();
        List<CustomerDTO> list = null;
        try{
            CustomerModel model = new CustomerModel();
            list = customerService.queryALLByDTO(model);
            logger.info("查到["+list.size()+"]条数据");
        }catch (Exception e){
            logger.error("系统异常...");
        }
        return list;
    }
}
