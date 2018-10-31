package com.example.demo.common.parent.Mapper.base.insert;

import com.example.demo.common.parent.Mapper.provider.AShareBaseInsertProvider;
import org.apache.ibatis.annotations.InsertProvider;

/**
 * 通用Mapper接口,插入
 *
 * @param <T> 不能为空
 */
public interface AShareInsertMapper<T> {
    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     *
     * @param record
     * @return
     */
    @InsertProvider(type = AShareBaseInsertProvider.class, method = "dynamicSQL")
    int insert(T record);
}