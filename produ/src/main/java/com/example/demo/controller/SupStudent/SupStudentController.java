package com.example.demo.controller.SupStudent;

import com.example.demo.DTO.query.SupStudentQueryDTO;
import com.example.demo.DTO.result.SupStudentResultDTO;
import com.example.demo.common.constants.IsConstants;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.facade.SupStudentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Hanyh
 * @create 2018-01-07 20:54
 * @desc
 **/
@Controller
@RequestMapping(value = "stuPath")
public class SupStudentController {

    @Autowired
    private SupStudentFacade supStudentFacade;

    @RequestMapping("/toList")
    public String toList(){
        return "/student/list";
    }
    @RequestMapping("/queryStu")
    @ResponseBody
    public ExecuteResult<PageInfo<SupStudentResultDTO>> queryStuList(SupStudentQueryDTO supStudentQueryDTO){
        supStudentQueryDTO.setIsFormal(IsConstants.IsFormal.YES);
        return supStudentFacade.stuListResult(supStudentQueryDTO);
    }

    @RequestMapping("/targetList")
    public String targetList(ModelMap map,Long id){
        map.put("workerId",id);
        return "/student/target_list";
    }

    @RequestMapping("/queryTargetStu")
    @ResponseBody
    public ExecuteResult<PageInfo<SupStudentResultDTO>> queryTargetStuList(SupStudentQueryDTO supStudentQueryDTO){
        supStudentQueryDTO.setIsFormal(IsConstants.IsFormal.NO);
        return supStudentFacade.stuListResult(supStudentQueryDTO);
    }

    @RequestMapping("/toQueryMark")
    public String toQueryMark(ModelMap map,Long id){
        map.put("stuId",id);
        return "/student/mark_list";
    }
}
