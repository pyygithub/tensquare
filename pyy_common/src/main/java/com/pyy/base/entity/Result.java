package com.pyy.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 响应结果集
 * @author panyy
 */
@Data
public class Result<T> {
    /** 返回码 */
    private Integer code;

    /** 返回信息 */
    private String message;

    /** 返回数据 */
    private T data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}