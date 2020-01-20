package com.tortoise.common.pagenation;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 分页查询结果分装
 * @author tortoielala
 */
@Data
@Builder
public class Page <T> {
    /**
     * 当前页
     */
    private int currentPage;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 当前页条目数量
     */
    private int pageSize;

    /**
     * 条目总数量
     */
    private int total;

    /**
     * 当前页数据
     */
    private List<T> list;
}
