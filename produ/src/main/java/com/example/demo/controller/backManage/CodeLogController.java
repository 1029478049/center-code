package com.example.demo.controller.backManage;

import com.example.demo.DTO.query.PlatformLogQueryDTO;
import com.example.demo.DTO.query.UserQueryDTO;
import com.example.demo.DTO.result.PlatformLogResultDTO;
import com.example.demo.DTO.result.UserResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.facade.CodeLogFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "codeLogs")
public class CodeLogController {

    @Autowired
    private CodeLogFacade codeLogFacade;
    @RequestMapping("/list")
    public ModelAndView list() {
        return new ModelAndView("/backManage/codeLogs/list");
    }

    @RequestMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("/backManage/codeLogs/add");
    }


    /**
     * 分页查询
     *
     * @param platformLogQueryDTO
     * @return ExecuteResult<PageInfo<UserResultDTO>>
     */
    @RequestMapping("/queryLogs")
    public ExecuteResult<PageInfo<PlatformLogResultDTO>> queryUserList(PlatformLogQueryDTO platformLogQueryDTO){
        return codeLogFacade.logsListResult(platformLogQueryDTO);
    }
    @RequestMapping("/deletedLog")
    public ExecuteResult<String> deletedUserById(Long id){
        return null;
    }
}
