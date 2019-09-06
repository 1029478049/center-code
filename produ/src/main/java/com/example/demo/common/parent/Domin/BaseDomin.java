package com.example.demo.common.parent.Domin;

import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Hanyh
 * @create 2017-12-11 19:04
 * @desc
 **/
@MappedSuperclass
public class BaseDomin  implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;
    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;
    /**
     * 修改时间
     */
    @Column(name = "uodate_time")
    private Date updateTime;
    /**
     * 上一次修改人
     */
    @Column(name = "last_modify_by")
    private String lastModifyBy;
    /**
     *上一次修改时间
     */
    @Column(name = "last_modify_time")
    private Date lastModifyTime;
    /**
     * 版本
     */
    @Column(name = "version")
    private Long version;
    @Column(name = "deleted")
    private Long deleted;

    public Long getDeleted() {
        return deleted;
    }

    public void setDeleted(Long deleted) {
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLastModifyBy() {
        return lastModifyBy;
    }

    public void setLastModifyBy(String lastModifyBy) {
        this.lastModifyBy = lastModifyBy;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
