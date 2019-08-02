package com.studydesign.studytoolbasic.util;


import com.querydsl.core.types.Order;
import io.swagger.annotations.ApiModelProperty;

public class PageQuery {
    @ApiModelProperty(value = "排序字段")
    private String orderField;
    @ApiModelProperty(value = "排序方向", example = "ASC")
    private Order order;
    @ApiModelProperty(value = "分页大小", example = "10000")
    private int size;
    @ApiModelProperty(value = "分页序号", example = "1")
    private int page;


    public PageQuery() {
        this(1, 10);
    }

    public PageQuery(int page, int size) {
        this.page = page;
        this.size = size;
        this.order = Order.ASC;
    }

    public long getStartIndex() {
        return (long) (this.size * (this.page - 1 >= 0 ? this.page - 1 : 0));
    }

    private long getEndIndex() {
        return this.getStartIndex() + (long) this.size - 1L;
    }

    public String getOrderField() {
        return this.orderField;
    }

    public Order getOrder() {
        return this.order;
    }

    public int getSize() {
        return this.size;
    }

    public int getPage() {
        return this.page;
    }


    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPage(int page) {
        this.page = page;
    }


    public String toString() {
        return "PageQuery(orderField=" + this.getOrderField() + ", order=" + this.getOrder() + ", size=" + this.getSize() + ", page=" + this.getPage() + ")";
    }
}
