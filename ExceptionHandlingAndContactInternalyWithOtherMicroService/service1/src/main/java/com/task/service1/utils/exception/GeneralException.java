package com.task.service1.utils.exception;

public class GeneralException extends RuntimeException {

    private String message;

    private final String errorReason;

    public GeneralException(final String message, final String errorReason) {
        super(message);
        this.message = message;
        this.errorReason = errorReason;
    }

    public GeneralException(String msg, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1, String errorReason) {
        super(msg, cause, enableSuppression, writableStackTrace);
        this.message = message1;
        this.errorReason = errorReason;
    }
}
