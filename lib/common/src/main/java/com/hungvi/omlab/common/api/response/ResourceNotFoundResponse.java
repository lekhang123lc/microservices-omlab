package com.hungvi.omlab.common.api.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResourceNotFoundResponse extends ResponseEntity<ResourceNotFoundResponse.Payload> {

    public ResourceNotFoundResponse(String message) {
        super(new Payload(ErrorCode.NOT_FOUND, message), HttpStatus.NOT_FOUND);
    }

    @Value
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Payload {
        ErrorCode errorCode;
        String message;
    }
}
