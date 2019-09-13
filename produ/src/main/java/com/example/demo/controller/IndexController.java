package com.example.demo.controller;

import com.example.demo.domin.LogItems;
import com.example.demo.domin.PlatformLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hanyh
 * @create 2017-12-06 14:23
 * @desc
 **/
@Controller
@RequestMapping(value = "paltform")
public class IndexController {

    @RequestMapping("/paltform")
    public String paltform() {
        return "/../../paltform";
    }

    @RequestMapping("/list")
    public String list(ModelMap modelMap) {
        List<PlatformLog> logs = new ArrayList<>();
        for(int i=1;i<=7;i++){
            PlatformLog platformLog = new PlatformLog();
            platformLog.setId(i);
            platformLog.setUpdateTime("2019-10-0"+i);
            platformLog.setVersion("V0.0."+i);
            platformLog.setRecommend("今天更新了内容什么什么什么");
            platformLog.setOpenItem(i == 1? "in" : "");
            List<LogItems> items = new ArrayList<>();
            for(int j = 1;j<=5;j++){
                LogItems item = new LogItems();
                item.setId(j);
                item.setText("更新条目"+j);
                items.add(item);
            }
            platformLog.setItems(items);
            logs.add(platformLog);
        }
        modelMap.put("logs",logs);
        return "/system/index";
    }
}
