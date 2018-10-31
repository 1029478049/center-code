package com.example.demo.facade.Impl;

import com.example.demo.DTO.query.SupStudentQueryDTO;
import com.example.demo.DTO.result.SupStudentResultDTO;
import com.example.demo.common.constants.IsConstants;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.DozerUtil;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.domin.SupStudent;
import com.example.demo.facade.SupStudentFacade;
import com.example.demo.service.SupStudentService;
import com.github.pagehelper.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hanyh
 * @create 2018-01-07 20:53
 * @desc
 **/
@Service
public class SupStudentFacadeImpl implements SupStudentFacade{

    private static final Logger logger = LogManager.getLogger(SupStudentFacadeImpl.class);
    @Autowired
    private SupStudentService supStudentService;
    @Override
    public ExecuteResult<PageInfo<SupStudentResultDTO>> stuListResult(SupStudentQueryDTO supStudentQueryDTO) {
        ExecuteResult<PageInfo<SupStudentResultDTO>> result = new ExecuteResult<>();
        try{
            SupStudent supStudent = DozerUtil.map(supStudentQueryDTO,SupStudent.class);
            Page<SupStudent> page = supStudentService.queryStuPage(supStudent);
            result.setResult(DozerUtil.mapPage(page.toPageInfo(),SupStudentResultDTO.class));
            result.setSuccessMessage("查询成功");
            logger.info("查到用户数为<{}>",page.size());
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }
}
