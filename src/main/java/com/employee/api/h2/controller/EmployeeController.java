package com.employee.api.h2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employee.api.h2.dto.EmployeeDTO;
import com.employee.api.h2.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Employee Controller", description = "Manage employee related activity")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Operation(summary = "Employee Welcome Note", description = "This end point for testing purpose")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Welcome Note", content = @Content(schema = @Schema(implementation = String.class))), //
			@ApiResponse(responseCode = "500", description = "Internal Server Exception", content = @Content(schema = @Schema(implementation = RuntimeException.class))) })
	@GetMapping("/welcome")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<String> getWelcome() {
		return ResponseEntity.ok("Welcome Employee Portal");
	}

	@Operation(summary = "Employee List", description = "This end point response all employee list")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetch all employee information", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EmployeeDTO.class)))), //
			@ApiResponse(responseCode = "500", description = "Internal Server Exception", content = @Content(schema = @Schema(implementation = RuntimeException.class))) })
	@GetMapping("/list")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<EmployeeDTO>> listAllEmoployees() {
		return ResponseEntity.ok(employeeService.listAllEmployees());
	}

	@Operation(summary = "Find Employee By Id", description = "This end point response employee information based on table primary key value")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetch employee by id", content = @Content(schema = @Schema(implementation = EmployeeDTO.class))), //
			@ApiResponse(responseCode = "500", description = "Internal Server Exception", content = @Content(schema = @Schema(implementation = RuntimeException.class))) })
	@GetMapping("/find/{empId}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<EmployeeDTO> findEmployeeByEmpId(@PathVariable final String empId) {
		return ResponseEntity.ok(employeeService.findEmployeeByEmpId(empId));
	}

	@Operation(summary = "Save employee information", description = "This end point will create employee information")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Save employee information", content = @Content(schema = @Schema(implementation = EmployeeDTO.class))), //
			@ApiResponse(responseCode = "500", description = "Internal Server Exception", content = @Content(schema = @Schema(implementation = RuntimeException.class))) })
	@PostMapping("/save")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return ResponseEntity.ok(employeeService.saveEmployee(employeeDTO));
	}

	@Operation(summary = "Update employee information", description = "This end point will update the exsting employee information based on table primary key value")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Update employee information", content = @Content(schema = @Schema(implementation = EmployeeDTO.class))), //
			@ApiResponse(responseCode = "500", description = "Internal Server Exception", content = @Content(schema = @Schema(implementation = RuntimeException.class))) })
	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return ResponseEntity.ok(employeeService.updateEmployee(employeeDTO));
	}

	@Operation(summary = "Delete employee information", description = "This end point will delete the exsting employee information based on table primary key value")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Delete employee information", content = @Content(schema = @Schema(implementation = EmployeeDTO.class))), //
			@ApiResponse(responseCode = "500", description = "Internal Server Exception", content = @Content(schema = @Schema(implementation = RuntimeException.class))) })
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<String> deleteEmployee(@PathVariable final Long id) {
		return ResponseEntity.ok(employeeService.deleteEmployee(id));
	}

}
