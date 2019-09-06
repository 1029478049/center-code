package com.example.demo.common.parent.DTO;

/**
 * 分页DTO
 * @author Hanyh
 * @create 2017-12-12 18:25
 * @desc
 **/
public class PageDTO extends BaseDTO {

    private static final long serialVersionUID = -1524194532303522641L;

    private Integer page = 1; // 当前页
    private Integer rows = 10; // 每页大小

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return rows;
    }

    public void setPageSize(Integer pageSize) {
        this.rows = pageSize;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

}
