package com.example.demo.controller.backManage;

import com.example.demo.DTO.query.RoleQueryDTO;
import com.example.demo.DTO.query.UserQueryDTO;
import com.example.demo.DTO.result.RoleResultDTO;
import com.example.demo.DTO.result.UserResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.facade.AacRoleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hanyh
 * @create 2018-01-10 10:44
 * @desc 角色列表
 **/
@Controller
@RequestMapping(value = "rolePath")
public class RoleController {

    @Autowired
    private AacRoleFacade aacRoleFacade;

    @RequestMapping("/list")
    public String listRole() {
        return "/backManage/role/list";
    }

    /**
     * 分页查询
     * @param roleQueryDTO
     * @return queryRole
     */
    @RequestMapping("/queryRole")
    @ResponseBody
    public ExecuteResult<PageInfo<RoleResultDTO>> queryRoleList(RoleQueryDTO roleQueryDTO){
        return aacRoleFacade.rolePageResult(roleQueryDTO);
    }

    /**
     * 查询用户对应的角色
     * @param roleQueryDTO
     * @return queryRole
     */
    @RequestMapping("/queryUserRole")
    @ResponseBody
    public ExecuteResult<PageInfo<RoleResultDTO>> queryUserRoleList(RoleQueryDTO roleQueryDTO){
        return aacRoleFacade.userRolePageResult(roleQueryDTO);
    }

    /**
     * 查询未绑定用户的角色
     * @param roleQueryDTO
     * @return
     */
    @RequestMapping("/queryUnboundUserRole")
    @ResponseBody
    public ExecuteResult<PageInfo<RoleResultDTO>> queryUnboundUserRoleList(RoleQueryDTO roleQueryDTO){
        return aacRoleFacade.unboundUserRolePageResult(roleQueryDTO);
    }
    /**
     * 去查看角色页面
     * @return
     */
    @RequestMapping("/toImpower")
    public String toImpower(ModelMap map,Long id){
        map.put("uId",id);
        return "/backManage/role/impower";
    }
    /**
     * 去授权页面
     * @return
     */
    @RequestMapping("/doImpower")
    public String doImpower(ModelMap map,Long id){
        map.put("uId",id);
        return "/backManage/role/doImpower";
    }

    /**
     * 授权按钮
     * @param uId
     * @param rId
     * @return
     */
    @RequestMapping("/doImpowerOper")
    @ResponseBody
    public ExecuteResult<String> doImpowerOper(Long uId, String rId){
        String[] split= rId.split(",");
        List<Long> list = new ArrayList<>();
        for(String s : split){
            list.add(Long.parseLong(s));
        }
        return aacRoleFacade.doImpowerOper(uId,list);
    }

    /**
     * 解除授权按钮
     * @param uId
     * @param rId
     * @return
     */
    @RequestMapping("/relieveImpowerOper")
    @ResponseBody
    public ExecuteResult<String> relieveImpowerOper(Long uId, String rId){
        String[] split= rId.split(",");
        List<Long> list = new ArrayList<>();
        for(String s : split){
            list.add(Long.parseLong(s));
        }
        return aacRoleFacade.relieveImpowerOper(uId,list);
    }
}
