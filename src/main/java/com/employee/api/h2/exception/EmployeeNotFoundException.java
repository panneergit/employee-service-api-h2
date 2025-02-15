package com.employee.api.h2.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}

	public EmployeeNotFoundException(Exception e, String message) {
		super(message, e);
	}
}
