package com.techpower.pitchweb.exception;

import com.techpower.pitchweb.utils.MessageSourceUtils;

public class BaseException extends RuntimeException {
    protected String errorCode;
    protected String message;

    public BaseException() {
    }

    public BaseException(String errorCode, Object... args) {
        this.errorCode = errorCode;
        this.message = MessageSourceUtils.getMessage(errorCode, args);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
