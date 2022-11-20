package com.hungvi.omlab.common.exception;

import com.hungvi.omlab.common.api.response.ErrorCode;
import lombok.Getter;


public class ResourceViolationException extends Exception {

    @Getter
    private ErrorCode errorCode;

    public ResourceViolationException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ResourceViolationException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ResourceViolationException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ResourceViolationException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public ResourceViolationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }
}
