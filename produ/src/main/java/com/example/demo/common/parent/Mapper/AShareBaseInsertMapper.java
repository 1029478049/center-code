package com.example.demo.common.parent.Mapper;


import com.example.demo.common.parent.Mapper.base.insert.AShareInsertMapper;
import com.example.demo.common.parent.Mapper.base.insert.AShareInsertSelectiveMapper;

/**
 * 通用Mapper接口, 解决version 字段  和 deleted 默认值
 *
 * @param <T> 不能为空
 * @author create by liwuyang on 2016-07-17 16:11
 */
public interface AShareBaseInsertMapper<T> extends
        AShareInsertMapper<T>,
        AShareInsertSelectiveMapper<T> {
}
