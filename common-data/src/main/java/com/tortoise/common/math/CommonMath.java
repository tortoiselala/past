package com.tortoise.common.math;

/**
 * @author wuyangmin
 * @date 2020/1/15
 */
public class CommonMath {

    public static int multiplyOrMaxInteger (int a, int b) {
        long r = (long) a * (long) b;
        if ((int)r != r) {
            return Integer.MAX_VALUE;
        }
        return (int)r;
    }
}
