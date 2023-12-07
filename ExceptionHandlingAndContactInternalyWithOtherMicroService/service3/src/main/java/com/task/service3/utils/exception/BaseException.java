package com.task.service3.utils.exception;

public class BaseException extends RuntimeException{

    private final String message;

    private final String errorReason;

    public BaseException(final String message, final String errorReason) {
        super(message);
        this.message = message;
        this.errorReason = errorReason;
    }

    public BaseException(String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1, String errorReason) {
        super(msg, cause, enableSuppression, writableStackTrace);
        this.message = message1;
        this.errorReason = errorReason;
    }
}
