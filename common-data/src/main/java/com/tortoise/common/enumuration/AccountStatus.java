package com.tortoise.common.enumuration;

import com.tortoise.common.base.RangeCodeValue;

/**
 * @author tortoielala
 */
public class AccountStatus implements RangeCodeValue {
    /**
     * code
     */
    private Integer code;
    /**
     * value
     */
    private String value;

    /**
     * 下界
     */
    private Integer lower;

    /**
     * 上界
     */
    private Integer upper;

    public Integer getCode() {
        return code;
    }

    public Integer lower() {
        return lower;
    }

    public Integer upper() {
        return upper;
    }

    public String getValue() {
        return value;
    }
}
