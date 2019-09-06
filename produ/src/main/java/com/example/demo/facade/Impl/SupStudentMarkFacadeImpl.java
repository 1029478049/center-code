package com.example.demo.facade.Impl;

import com.example.demo.DTO.query.SupStudentMarkQueryDTO;
import com.example.demo.DTO.result.SupStudentMarkResultDTO;
import com.example.demo.DTO.result.SupStudentResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.DozerUtil;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.domin.SupStudent;
import com.example.demo.domin.SupStudentMark;
import com.example.demo.facade.SupStudentMarkFacade;
import com.example.demo.service.SupStudentMarkService;
import com.github.pagehelper.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hanyh
 * @create 2018-01-08 14:33
 * @desc
 **/
@Service
public class SupStudentMarkFacadeImpl implements SupStudentMarkFacade {

    private static final Logger logger = LogManager.getLogger(SupStudentMarkFacadeImpl.class);
    @Autowired
    private SupStudentMarkService supStudentMarkService;

    @Override
    public ExecuteResult<PageInfo<SupStudentMarkResultDTO>> queryMarkByDTO(SupStudentMarkQueryDTO supStudentMarkQueryDTO) {
        ExecuteResult<PageInfo<SupStudentMarkResultDTO>> result = new ExecuteResult<>();
        try{
            SupStudentMark supStudent = DozerUtil.map(supStudentMarkQueryDTO,SupStudentMark.class);
            Page<SupStudentMark> page = supStudentMarkService.queryStuMarkPage(supStudent);
            result.setResult(DozerUtil.mapPage(page.toPageInfo(),SupStudentMarkResultDTO.class));
            result.setSuccessMessage("查询成功");
            logger.info("查到用户数为<{}>",page.size());
        }catch (Exception e){
            logger.error("系统异常",e);
        }
        return result;
    }
}
