package com.example.demo.DTO.result;

import com.example.demo.common.parent.DTO.PageDTO;
import com.example.demo.domin.LogItems;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlatformLogResultDTO extends PageDTO {

    /**
     * 更新版本
     */
    private String updateVersion;
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

