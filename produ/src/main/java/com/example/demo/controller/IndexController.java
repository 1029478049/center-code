package com.example.demo.controller;

import com.example.demo.DTO.result.PlatformLogResultDTO;
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
        List<PlatformLogResultDTO> logs = new ArrayList<>();
            //有服务器查库
            PlatformLogResultDTO platformLog = new PlatformLogResultDTO();
            platformLog.setId(1L);
            platformLog.setUpdateTime("2019-9-17");
            platformLog.setUpdateVersion("V0.0.1");
            platformLog.setRecommend("大体总结：redis集群");
            platformLog.setOpenItem("in");
            List<LogItems> items = new ArrayList<>();
                LogItems item1 = new LogItems();
                item1.setId(1);
                item1.setText("redis安装和单机多节点集群网址:"+"https://www.cnblogs.com/tomasman/p/8288569.html");
                LogItems item2 = new LogItems();
                item2.setId(2);
                item2.setText("Mac OS X 安装Ruby:"+"https://www.cnblogs.com/huanghaipo/p/7478625.html");
                LogItems item3 = new LogItems();
                item3.setId(3);
                item3.setText("springBoot整合redisCluster(redis集群)模式，包路径:"+"com.example.demo.config.redis");
                LogItems item4 = new LogItems();
                item4.setId(4);
                item4.setText("集群redis测试类:"+"com.example.demo.controller.redisTest.CityController");
                items.add(item1);
                items.add(item2);
                items.add(item3);
            platformLog.setItems(items);
            logs.add(platformLog);

        modelMap.put("logs",logs);
        return "/system/index";
    }
}
