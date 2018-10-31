package com.example.demo.domin;

import java.util.Date;

/**
 * @author Hanyh
 * @create 2017-11-20 14:50
 * @desc
 **/
public class Customer {
    /**
     * ID
     */
    private Long id;
    /**
     * 客户名称
     */
    private String custName;
    /**
     * 客户类型
     */
    private Long custType;
    /**
     * 客户属地(所在市）
     */
    private Long custBelong;
    /**
     * 客户地址
     */
    private String custAddr;
    /**
     * 客户网站
     */
    private String custWebsite;
    /**
     * 项目启动日期
     */
    private Date created;
    /**
     * 更新日期
     */
    private Date updated;
    /**
     * 销售经理
     */
    private Long saleMge;
    /**
     * 操作人员ID
     */
    private Long oper;
    /**
     * 状态
     */
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Long getCustType() {
        return custType;
    }

    public void setCustType(Long custType) {
        this.custType = custType;
    }

    public Long getCustBelong() {
        return custBelong;
    }

    public void setCustBelong(Long custBelong) {
        this.custBelong = custBelong;
    }

    public String getCustAddr() {
        return custAddr;
    }

    public void setCustAddr(String custAddr) {
        this.custAddr = custAddr;
    }

    public String getCustWebsite() {
        return custWebsite;
    }

    public void setCustWebsite(String custWebsite) {
        this.custWebsite = custWebsite;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getSaleMge() {
        return saleMge;
    }

    public void setSaleMge(Long saleMge) {
        this.saleMge = saleMge;
    }

    public Long getOper() {
        return oper;
    }

    public void setOper(Long oper) {
        this.oper = oper;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
