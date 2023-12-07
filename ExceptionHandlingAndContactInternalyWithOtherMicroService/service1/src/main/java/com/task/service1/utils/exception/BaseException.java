package com.task.service1.utils.exception;

public class BaseException extends RuntimeException{

    private final String message;

    private final String errorReason;

    public BaseException(final String message, final String errorReason) {
        super(message);
        this.message = message;
        this.errorReason = errorReason;
    }
}
