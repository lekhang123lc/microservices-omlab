package com.hungvi.omlab.common.api.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ValidationFailedResponse extends ResponseEntity<ValidationFailedResponse.Payload> {

    public ValidationFailedResponse(ErrorCode _errorCode, String _message) {
        super(new Payload(HttpStatus.BAD_REQUEST.value(), _errorCode, _message), HttpStatus.BAD_REQUEST);
    }

    @Value
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Payload {
        Integer status;
        ErrorCode errorCode;
        String message;

    }
}

