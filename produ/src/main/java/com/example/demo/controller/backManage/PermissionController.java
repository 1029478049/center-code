package com.example.demo.controller.backManage;

import com.example.demo.DTO.query.PermissionQueryDTO;
import com.example.demo.DTO.result.PermissionResultDTO;
import com.example.demo.common.parent.Page.PageInfo;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.facade.AacPermissionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Hanyh
 * @create 2018-01-10 10:44
 * @desc 资源列表
 **/
@Controller
@RequestMapping(value = "permissionPath")
public class PermissionController {

    @Autowired
    private AacPermissionFacade aacPermissionFacade;
    @RequestMapping("/list")
    public String listRole() {
        return "/backManage/permission/list";
    }
    /**
     * 分页查询
     * @param permissionQueryDTO
     * @return queryPermission
     */
    @RequestMapping("/queryPermission")
    @ResponseBody
    public ExecuteResult<PageInfo<PermissionResultDTO>> queryRoleList(PermissionQueryDTO permissionQueryDTO){
        return aacPermissionFacade.permissionPageResult(permissionQueryDTO);
    }

    /**
     * 查看该角色的资源
     * @param map
     * @param id
     * @return 该角色的资源页面
     */
    @RequestMapping("/queryRolePermission")
    public String queryPermission(ModelMap map,Long id) {
        map.put("roleId",id);
        return "/backManage/permission/queryPermission";
    }

    /**
     * 查看该角色挂的资源
     * @param permissionQueryDTO
     * @return
     */
    @RequestMapping("/queryBoundRolePermission")
    @ResponseBody
    public ExecuteResult<PageInfo<PermissionResultDTO>> queryRolePermissionList(PermissionQueryDTO permissionQueryDTO){
        return aacPermissionFacade.rolePermPageResult(permissionQueryDTO);
    }
    /**
     * 查看该角色挂的资源
     * @param permissionQueryDTO
     * @return
     */
    @RequestMapping("/queryUnboundRolePermission")
    @ResponseBody
    public ExecuteResult<PageInfo<PermissionResultDTO>> queryUnboundRolePermissionList(PermissionQueryDTO permissionQueryDTO){
        return aacPermissionFacade.unboundrolePermPageResult(permissionQueryDTO);
    }

    /**
     * 给该角色关联资源页面
     * @param map
     * @param id
     * @return 该角色关联资源页面
     */
    @RequestMapping("/conPermission")
    public String conPermission(ModelMap map,Long id) {
        map.put("roleId",id);
        return "/backManage/permission/conPermission";
    }

    /**
     * 去做关联资源操作
     * @param roleId
     * @param pId
     * @return
     */
    @RequestMapping("/doConnet")
    @ResponseBody
    public String con(Long roleId,String pId){
        return "";
    }
}
