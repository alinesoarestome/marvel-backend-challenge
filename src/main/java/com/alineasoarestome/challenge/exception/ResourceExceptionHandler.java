package com.alineasoarestome.challenge.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ApiError handleNotFoundException(NotFoundException ex) {
	log.error(ex.getMessage(),ex);
	return new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
    }

    @ExceptionHandler(Exception.class)
    public ApiError handlerError(final Exception ex) {
	log.error(ex.getMessage(),ex);
	return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
		ApiError.UNEXPECTED_ERROR.concat(":").concat(ex.getMessage()), new Date());
    }
}
