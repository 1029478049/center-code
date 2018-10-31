package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Hanyh
 * @create 2017-12-06 14:23
 * @desc
 **/
@Controller
@RequestMapping(value = "login")
public class IndexController {

    @RequestMapping("/paltform")
    public String paltform() {
        return "/../../paltform";
    }
}
