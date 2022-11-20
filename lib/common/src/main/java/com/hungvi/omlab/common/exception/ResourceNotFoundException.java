package com.hungvi.omlab.common.exception;

import com.hungvi.omlab.common.api.response.ErrorCode;
import lombok.Getter;


public class ResourceNotFoundException extends Exception {

    @Getter
    private ErrorCode errorCode = ErrorCode.NOT_FOUND;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
