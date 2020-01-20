package com.tortoise.common.exception;

/**
 * @author wuyangmin
 * @date 2020/1/15
 */
public class BaseRuntimException extends RuntimeException {

    public BaseRuntimException() {
        super();
    }

    public BaseRuntimException(String message) {
        super(message);
    }

    public BaseRuntimException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseRuntimException(Throwable cause) {
        super(cause);
    }

    protected BaseRuntimException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
