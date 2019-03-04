package com.pyy.base.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 分页结果类
 * @author panyy
 */
@Data
@AllArgsConstructor
public class PageResult<T> {
    /** 总页数 */
    private Long total;

    /** 数据集合 */
    private List<T> rows;
}