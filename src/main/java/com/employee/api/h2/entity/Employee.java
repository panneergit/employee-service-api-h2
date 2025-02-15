package com.employee.api.h2.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "emp_id")
	private String empId;

	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "dob")
	private LocalDate dob;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "address")
	private String address;

	@Column(name = "department")
	private String dept;

	@Column(name = "salary")
	private Double salary;
}
