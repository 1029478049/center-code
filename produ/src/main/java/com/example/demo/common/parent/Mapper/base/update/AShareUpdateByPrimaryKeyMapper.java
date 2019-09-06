package com.example.demo.common.parent.Mapper.base.update;

import com.example.demo.common.parent.Mapper.provider.AShareBaseUpdateProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * 通用Mapper接口,更新(处理乐观锁)
 *
 * @param <T> 不能为空
 */
public interface AShareUpdateByPrimaryKeyMapper<T> {

    /**
     * 根据主键更新实体全部字段，null值会被更新(处理乐观锁)
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = AShareBaseUpdateProvider.class, method = "dynamicSQL")
    int updateCASByPrimaryKey(T record);
}