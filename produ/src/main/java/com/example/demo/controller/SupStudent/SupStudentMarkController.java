package com.example.demo.controller.SupStudent;

import com.example.demo.DTO.query.SupStudentMarkQueryDTO;
import com.example.demo.DTO.result.SupStudentMarkResultDTO;
import com.example.demo.DTO.result.SupStudentResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.facade.SupStudentMarkFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Hanyh
 * @create 2018-01-08 14:20
 * @desc
 **/
@Controller
@RequestMapping(value = "stuMarkPath")
public class SupStudentMarkController {

    @Autowired
    private SupStudentMarkFacade supStudentMarkFacade;

    @RequestMapping(value = "queryMark")
    @ResponseBody
    public ExecuteResult<PageInfo<SupStudentMarkResultDTO>> queryMark(SupStudentMarkQueryDTO supStudentMarkQueryDTO){
        return supStudentMarkFacade.queryMarkByDTO(supStudentMarkQueryDTO);
    }
}
