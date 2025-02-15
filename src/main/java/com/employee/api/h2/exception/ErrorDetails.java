package com.employee.api.h2.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {
	private LocalDateTime timesstamp;
	private String status;
	private String message;	
}
