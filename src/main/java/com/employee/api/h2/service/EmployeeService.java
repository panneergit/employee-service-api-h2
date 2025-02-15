package com.employee.api.h2.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.api.h2.dto.EmployeeDTO;
import com.employee.api.h2.entity.Employee;
import com.employee.api.h2.exception.EmployeeNotFoundException;
import com.employee.api.h2.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapper mapper;

	public EmployeeService(EmployeeRepository employeeRepository, ModelMapper mapper) {
		this.employeeRepository = employeeRepository;
		this.mapper = mapper;
	}

	public List<EmployeeDTO> listAllEmployees() {
		var employeeList = employeeRepository.findAll();
		return mapper.map(employeeList, new TypeToken<List<EmployeeDTO>>() {
		}.getType());
	}

	public EmployeeDTO findEmployeeByEmpId(String empId) {
		return mapper.map(employeeRepository.findEmployeeByEmpId(empId), EmployeeDTO.class);
	}

	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
		var employee = mapper.map(employeeDTO, Employee.class);
		employee.setId(null);
		var tmpEmployee = employeeRepository.save(employee);
		return mapper.map(tmpEmployee, EmployeeDTO.class);
	}

	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws EmployeeNotFoundException {

		var employee = employeeRepository.findById(employeeDTO.getId());

		if (!employee.isPresent()) {
			throw new EmployeeNotFoundException("Employee is not found");
		}

		employee.get().setEmpId(employeeDTO.getEmpId());
		employee.get().setName(employeeDTO.getName());
		employee.get().setDob(employeeDTO.getDob());
		employee.get().setGender(employeeDTO.getGender());
		employee.get().setMobile(employeeDTO.getMobile());
		employee.get().setAddress(employeeDTO.getAddress());
		employee.get().setEmailId(employeeDTO.getEmailId());
		employee.get().setDept(employeeDTO.getDept());
		employee.get().setSalary(employeeDTO.getSalary());

		var tmpEmployee = employeeRepository.save(employee.get());
		return mapper.map(tmpEmployee, EmployeeDTO.class);
	}

	public String deleteEmployee(Long id) throws EmployeeNotFoundException {
		var employee = employeeRepository.findById(id);

		if (!employee.isPresent()) {
			throw new EmployeeNotFoundException("Employee is not found");
		}
		employeeRepository.delete(employee.get());

		return "Deleted Successfully";
	}

}
