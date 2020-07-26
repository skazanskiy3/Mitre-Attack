package com.demo.mitreattack.controller.advice;

import com.demo.mitreattack.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.utils.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public final ErrorResponse handleNotFoundExceptions(Exception exception) {
        Throwable cause = findCause(exception);
        log.debug("The error message is: {} {}", cause.getMessage(), ExceptionUtils.getStackTrace(exception));
        return ErrorResponse.builder()
                .message(cause.getMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public final ErrorResponse handleValidationExceptions(Exception exception) {
        Throwable cause = findCause(exception);
        log.error("The error message is: {} {}", cause.getMessage(), ExceptionUtils.getStackTrace(exception));
        return ErrorResponse.builder()
                .message("An internal error happened, please view logs")
                .build();
    }

    private static Throwable findCause(Throwable throwable) {
        Objects.requireNonNull(throwable);
        Throwable rootCause = throwable;
        while (rootCause.getCause() != null && rootCause.getCause() != rootCause) {
            rootCause = rootCause.getCause();
        }
        return rootCause;
    }
}
