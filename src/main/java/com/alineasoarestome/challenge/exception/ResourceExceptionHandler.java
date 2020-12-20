package com.alineasoarestome.challenge.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    @ApiResponse(responseCode = "404", description = "Record not found", content = @Content(schema = @Schema(hidden = true)))
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ApiError handleNotFoundException(RecordNotFoundException ex) {
	log.error(ex.getMessage(), ex);
	return new ApiError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ApiResponse(responseCode = "500", description = "Unexpected Error", content = @Content(schema = @Schema(hidden = true)))
    public ApiError handleServerError(Exception ex) {
	log.error(ex.getMessage(), ex);
	return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR.value(),
		ApiError.UNEXPECTED_ERROR.concat(":").concat(ex.getMessage()), new Date());
    }
}
