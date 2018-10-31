package com.example.demo.common.parent.Domin;

import javax.persistence.Transient;

/**
 * @author Hanyh
 * @create 2017-12-12 18:25
 * @desc 分页基础类
 */
public class PageModel extends BaseDomin{

    @Transient
    private Integer page; // 当前页
    @Transient
    private Integer pageSize; // 每页大小

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void fetchAll(){
        this.page = 1;
        this.pageSize = -1;
    }

}
