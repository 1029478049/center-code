package com.example.demo.common.parent.DTO;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Hanyh
 * @create 2017-12-12 18:25
 * @desc
 **/
public class BaseDTO implements Serializable{

    private Long id;

    private String createBy;

    private String lastModifyBy;

    //@JSONField(format = "yyyy-MM-dd")
    private Date createTime;

    //@JSONField(format = "yyyy-MM-dd")
    private Date lastModifyTime;

    /** 版本号（乐观锁）  严禁设置默认值 */
    private Long version;

    /** 逻辑删除标记 默认0:未删除 */
    private Integer deleted ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(String lastModifyBy) {
        this.lastModifyBy = lastModifyBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
