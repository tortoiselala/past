package com.tortoise.common.base;

import com.tortoise.common.math.CommonMath;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wuyangmin
 * @date 2020/1/15
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page implements Serializable {
    private Integer pageNum;
    private Integer pageSize;


    public Integer getLimit () {
        return pageSize;
    }

    public Integer getOffset () {
        return CommonMath.multiplyOrMaxInteger(pageSize, pageNum);
    }

}
