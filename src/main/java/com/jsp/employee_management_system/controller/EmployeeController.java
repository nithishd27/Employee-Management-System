package com.jsp.employee_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.employee_management_system.entity.Employee;
import com.jsp.employee_management_system.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public String createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/{email}")
	public Employee fetchEmployeeById(@PathVariable String email) {
		return employeeService.fetchEmployeeById(email);
	}
	
	@GetMapping
	public List<Employee> fetchAllEmployee() {
		return employeeService.fetchAllEmployee();
	}
	
	@DeleteMapping("/{email}")
	public String deleteEmployeeById(@PathVariable String email) {
		employeeService.deleteEmployeeById(email);
		return "employee data deleted";
		
	}

	
	@PutMapping("/{email}")
	public String updateEmailById(@Valid @PathVariable String email, @RequestBody  Employee employee) {
		return employeeService.updateEmployeeById(email,employee);
	}
			
	
	
	
}

