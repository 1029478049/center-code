package com.example.demo.domin;

import com.example.demo.common.parent.Domin.PageModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "platform_Log")
public class PlatformLog extends PageModel {

    /**
     * 更新版本
     */
    private String updateVersion;
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
