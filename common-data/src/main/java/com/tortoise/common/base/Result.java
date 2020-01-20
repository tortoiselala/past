package com.tortoise.common.base;

import lombok.*;

import java.io.Serializable;

/**
 * 结果封装，适用于网络传输方式
 * @author tortoielala
 * @param <T>
 */
@ToString
@Setter
@Getter
@Builder
public class Result<T> implements Serializable {
    /**
     * 状态码
     */
    private StatusCode statusCode;
    /**
     * 数据
     */
    private T data;
    /**
     * 附加信息说明
     */
    private String message;

    public boolean isSuccess () {
        return StatusCode.SUCCESS.getCode().equals(statusCode.getCode());
    }

    public boolean isFailed () {
        return !isSuccess();
    }
}
