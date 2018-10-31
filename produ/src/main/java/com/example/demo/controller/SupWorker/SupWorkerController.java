package com.example.demo.controller.SupWorker;

import com.example.demo.DTO.query.SupStudentQueryDTO;
import com.example.demo.DTO.query.SupWorkerQueryDTO;
import com.example.demo.DTO.result.SupStudentResultDTO;
import com.example.demo.DTO.result.SupWorkerResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.facade.SupWorkerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Hanyh
 * @create 2018-01-08 16:01
 * @desc
 **/
@Controller
@RequestMapping(value = "workPath")
public class SupWorkerController {

    @Autowired
    private SupWorkerFacade supWorkerFacade;

    @RequestMapping("toList")
    public String toList(){
        return "/worker/list";
    }
    @RequestMapping("/queryWork")
    @ResponseBody
    public ExecuteResult<PageInfo<SupWorkerResultDTO>> queryUserList(SupWorkerQueryDTO supWorkerQueryDTO){
        return supWorkerFacade.workListResult(supWorkerQueryDTO);
    }
}
