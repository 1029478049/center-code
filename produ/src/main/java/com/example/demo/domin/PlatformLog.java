package com.example.demo.domin;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PlatformLog {

    private int id;
    /**
     * 更新版本
     */
    private String version;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 大体介绍
     */
    private String recommend;
    /**
     * 设置打开tab项
     */
    private String openItem;

    /**
     * 修改明细
     */
    private List<LogItems> items;
}
