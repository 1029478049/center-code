package com.example.demo.common.parent.Service.Impl;

/**
 * @author Hanyh
 * @create 2017-12-25 13:39
 * @desc
 **/

import com.example.demo.common.parent.Domin.BaseDomin;
import com.example.demo.common.parent.Mapper.IMapper;
import com.example.demo.common.parent.Service.BaseService;
import com.example.demo.common.util.BeanUtil;
import com.example.demo.common.util.SubjectUtil;
import org.apache.ibatis.mapping.MappedStatement;

import javax.persistence.OptimisticLockException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BaseServiceImpl<T extends BaseDomin> implements BaseService<T> {

    protected abstract IMapper<T> getBaseMapper();

    @Override
    public List<T> query(T record) {
        return this.getBaseMapper().select(record);
    }

    @Override
    public T queryById(Long id) {
        return this.getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    public List<T> queryById(List<Long> ids) {
        if (BeanUtil.isEmpty(ids)) {
            throw new OptimisticLockException("id集合不能为空，查询失败。");
        }
        List<T> list = new ArrayList<>();
        for (Long id : ids) {
            T t = this.queryById(id);
            list.add(t);
        }
        return list;
    }

    @Override
    public List<T> queryAll() {
        return this.getBaseMapper().selectAll();
    }

    @Override
    public T queryOne(T record) {
        return this.getBaseMapper().selectOne(record);
    }

    @Override
    public int queryCount(T record) {
        return this.getBaseMapper().selectCount(record);
    }

    @Override
    public int add(T record) {
//        record.setVersion(1L); // 新增时初始版本为1
//        record.setCreateBy(SubjectUtil.getUser().getLoginName()==null?"":SubjectUtil.getUser().getLoginName());
        record.setCreateBy(getCurrentUser(record));
        record.setLastModifyBy(getCurrentUser(record));
        Date currentDate = new Date();
        record.setCreateTime(currentDate);
        record.setLastModifyTime(currentDate);
        int count = this.getBaseMapper().insert(record);
        if (count > 0) {
            record.setVersion(1L); // 新增成功默认为1
        }
        return count;
    }

    @Override
    public int addSelective(T record) {
        //record.setVersion(1L); // 新增时初始版本为1
        record.setCreateBy(getCurrentUser(record));
        record.setLastModifyBy(getCurrentUser(record));
        Date currentDate = new Date();
        record.setCreateTime(currentDate);
        record.setLastModifyTime(currentDate);
        int count = this.getBaseMapper().insert(record);
        if (count > 0) {
            record.setVersion(1L); // 新增成功默认为1
        }
        return count;
    }

    @Override
    public int updateById(T record) {
        record.setLastModifyBy(getCurrentUser(record));
        record.setLastModifyTime(new Date());
        int count = this.getBaseMapper().updateCASByPrimaryKey(record);
        if (count <= 0) {
            throw new OptimisticLockException("根据ID更新整个实体对象时乐观锁版本不一致，更新失败。");
        } else {
            long version = record.getVersion() + 1L;
            record.setVersion(version);
        }
        return count;
    }

    @Override
    public int updateByIdSelective(T record) {
        record.setLastModifyBy(getCurrentUser(record));
        record.setLastModifyTime(new Date());
        int count = this.getBaseMapper().updateCASByPrimaryKeySelective(record);
        if (count <= 0) {
            throw new OptimisticLockException("根据ID更新实体对象指定字段时乐观锁版本不一致，更新失败。");
        } else {
            long version = record.getVersion() + 1L;
            record.setVersion(version);
        }
        return count;
    }

    //    @Override
    //    public int deleteById(Long id) {
    //        return this.getBaseMapper().deleteByPrimaryKey(id);
    //    }

    @Override
    public int remove(T record) {
        record.setDeleted(1L); // 删除标记 1：已删除
        record.setLastModifyBy(getCurrentUser(record));
        record.setLastModifyTime(new Date());
        int count = this.getBaseMapper().updateCASByPrimaryKey(record);
        if (count <= 0) {
            throw new OptimisticLockException("根据ID逻辑删除实体对象时乐观锁版本不一致，逻辑删除失败。");
        } else {
            long version = record.getVersion() + 1L;
            record.setVersion(version);
        }
        return count;
    }

    @Override
    public int addAll(List<T> recordList) {
        return this.getBaseMapper().insertList(recordList);
    }

    /**
     * 获取当前用户
     * 如实体传入，则使用实体传入的
     * 如实体未传入，则使用Session中LoginUser的用户名
     *
     * @param record
     * @return currentUser
     */
    protected String getCurrentUser(T record) {
        String loginName = SubjectUtil.getUser().getUserName() == null ? "" : SubjectUtil.getUser().getUserName();
        String currentUser = BeanUtil.isEmpty(record.getCreateBy()) ? loginName : record.getCreateBy();
        return currentUser;
    }
}

