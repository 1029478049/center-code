package com.example.demo.common.parent.Mapper.base.update;

import com.example.demo.common.parent.Mapper.provider.AShareBaseUpdateProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * 通用Mapper接口,更新(处理乐观锁)
 *
 * @param <T> 不能为空
 * @author create by liwuyang on 2016-07-17 16:07 
 */
public interface AShareUpdateByPrimaryKeySelectiveMapper<T> {

    /**
     * 根据主键更新属性不为null的值(处理乐观锁)
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = AShareBaseUpdateProvider.class, method = "dynamicSQL")
    int updateCASByPrimaryKeySelective(T record);

}