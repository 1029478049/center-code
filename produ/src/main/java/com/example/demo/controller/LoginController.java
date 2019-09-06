package com.example.demo.controller;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.DTO.query.UserQueryDTO;
import com.example.demo.DTO.result.UserResultDTO;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.common.util.WebSubjectUtil;
import com.example.demo.facade.AacUserFacade;
import com.example.demo.facade.CustomerFacade;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hanyh
 * @create 2017-11-20 11:18
 * @desc
 **/
@Controller
public class LoginController {

    @Autowired
    private CustomerFacade customerFacade;

    @RequestMapping("/login")
    public String index() {
        return "/login";
    }
    /**
     * ajax登录请求
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="ajaxLogin",method= RequestMethod.POST)
    @ResponseBody
    public ExecuteResult<Map<String,Object>> submitLogin(String username,String password) {
        ExecuteResult<Map<String,Object>> resultMap = new ExecuteResult<>();
        try {
            //校验
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(token);
            resultMap.setSuccessMessage("登陆成功");
        } catch (Exception e) {
            resultMap.addErrorMessage(e.getMessage());
        }
        return resultMap;
    }

    /**
     * 退出
     * @return login
     */
    @RequestMapping(value = "/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "/login";
    }

    @RequestMapping(value = "/paltform")
    public String paltform(ModelMap map) {
        String userName = WebSubjectUtil.getUser().getUserName();
        map.put("userName",userName);
        return "/paltform";
    }



    @RequestMapping("/queryAll")
    @ResponseBody
    public ExecuteResult<List<CustomerDTO>> queryAll(CustomerDTO customerDTO){
        return customerFacade.queryAllByDTO(customerDTO);
    }
    @RequestMapping("/query")
    @ResponseBody
    public List<CustomerDTO> query(CustomerDTO customerDTO){
        return customerFacade.queryByDTO(customerDTO);
    }

}
