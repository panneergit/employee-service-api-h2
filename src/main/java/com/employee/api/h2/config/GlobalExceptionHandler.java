package com.employee.api.h2.config;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.api.h2.exception.ErrorDetails;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> hendelGenericException(Exception e) {
		var errorDetail = new ErrorDetails();
		errorDetail.setTimesstamp(LocalDateTime.now());
		errorDetail.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		errorDetail.setMessage(e.getMessage());
		return ResponseEntity.ok(errorDetail);
	}
}