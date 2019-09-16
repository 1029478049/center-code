package com.example.demo.DTO.query;

import com.example.demo.common.parent.DTO.PageDTO;
import lombok.Data;

@Data
public class PlatformLogQueryDTO extends PageDTO {
    /**
     * 更新版本
     */
    private String version;
}
