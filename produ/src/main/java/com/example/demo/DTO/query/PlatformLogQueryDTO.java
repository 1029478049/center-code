package com.example.demo.DTO.query;

import com.example.demo.common.parent.DTO.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlatformLogQueryDTO extends PageDTO {
    /**
     * 更新版本
     */
    private String updateVersion;
}
