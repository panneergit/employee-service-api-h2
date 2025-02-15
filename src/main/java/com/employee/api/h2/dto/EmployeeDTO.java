package com.employee.api.h2.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeDTO {
	private long id;
	private String empId;
	private String name;
	private String gender;
	private LocalDate dob;
	private String mobile;
	private String emailId;
	private String address;
	private String dept;
	private Double salary;
}
