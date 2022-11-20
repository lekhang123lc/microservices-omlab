package com.hungvi.omlab.common.api.foundation;

import com.hungvi.omlab.common.api.response.ErrorCode;
import com.hungvi.omlab.common.api.response.ResourceNotFoundResponse;
import com.hungvi.omlab.common.api.response.ValidationFailedResponse;
import com.hungvi.omlab.common.exception.ResourceNotFoundException;
import com.hungvi.omlab.common.exception.ResourceViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler
    public ResponseEntity badRequest(ResourceViolationException e) {
        if (e.getErrorCode() != null) {
            return new ValidationFailedResponse(e.getErrorCode(), e.getMessage());
        } else {
            return new ValidationFailedResponse(ErrorCode.BAD_REQUEST, e.getMessage());
        }
    }

    @ExceptionHandler
    public ResponseEntity notFound(ResourceNotFoundException e) {
        return new ResourceNotFoundResponse(e.getMessage());
    }

}
