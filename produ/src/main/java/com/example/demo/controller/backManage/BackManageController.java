package com.example.demo.controller.backManage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Hanyh
 * @create 2017-12-13 21:57
 * @desc 后台管理
 **/
@Controller
@RequestMapping(value = "backManage")
public class BackManageController {
    @RequestMapping("/index")
    public String index() {
        return "/backManage/backIndex";
    }

    @RequestMapping("/userPage")
    public String user() {
        return "/backManage/user/userPage";
    }
    @RequestMapping("/welcome")
    public String welcome() {
        return "/backManage/welcome";
    }
}
