package com.qingyunqifu.utils;

/**
 * 分页实体
 */
public class PageModel {
    //当前页面
    private int pageIndex;

    //每页数据量
    private int pageSize = QinyunConstants.PAGE_DEFAULT_SIZE;

    //分页总数据条数
    private int recordCount;

    //总页数
    private int totalPage;

    public int getRecordCount() {
        this.recordCount = this.recordCount <= 0 ? 0 : this.recordCount;
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageIndex() {
        //如果索引过大就设为最后一页或者第一页，否则就是当前
        this.pageIndex = this.pageIndex <= 0 ? 1 : this.pageIndex;
        this.pageIndex = this.pageIndex >= this.getTotalPage() ? this.getTotalPage() : this.pageIndex;
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        this.pageSize = this.pageSize <= QinyunConstants.PAGE_DEFAULT_SIZE ? QinyunConstants.PAGE_DEFAULT_SIZE : this.pageSize;
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        if (this.getRecordCount() <= 0) {
            totalPage = 0;
        } else {
            //总页数 = 总数据/每页条数
            totalPage = (this.getRecordCount() - 1) / this.getPageSize() + 1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getFirstLimitParam() {
        return (this.getPageIndex() - 1) * this.getPageSize();
    }
}