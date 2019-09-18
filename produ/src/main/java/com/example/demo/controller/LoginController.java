package com.example.demo.controller;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.common.util.ExecuteResult;
import com.example.demo.common.util.WebSubjectUtil;
import com.example.demo.facade.CustomerFacade;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 登陆控制器
 */
@RestController
public class LoginController {

    @Autowired
    private CustomerFacade customerFacade;

    @RequestMapping("/login")
    public ModelAndView index() {
        return new ModelAndView("/login");
    }
    /**
     * ajax登录请求
     * @param username 用户名
     * @param password 密码
     * @return ExecuteResult<Map<String,Object>>
     */
    @RequestMapping(value="ajaxLogin",method= RequestMethod.POST)
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
    public ModelAndView logout() {
        SecurityUtils.getSubject().logout();
        return new ModelAndView("/login");
    }

    /**
     * 首页
     * @param map map
     * @return /paltform
     */
    @RequestMapping(value = "/paltform")
    public ModelAndView paltform(ModelMap map) {
        String userName = WebSubjectUtil.getUser().getUserName();
        map.put("userName",userName);
        return new ModelAndView("/paltform");
    }



    @RequestMapping("/queryAll")
    public ExecuteResult<List<CustomerDTO>> queryAll(CustomerDTO customerDTO){
        return customerFacade.queryAllByDTO(customerDTO);
    }
    @RequestMapping("/query")
    public List<CustomerDTO> query(CustomerDTO customerDTO){
        return customerFacade.queryByDTO(customerDTO);
    }

}
