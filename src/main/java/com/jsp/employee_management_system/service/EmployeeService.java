package com.jsp.employee_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jsp.employee_management_system.entity.Employee;
import com.jsp.employee_management_system.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public String createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Employee data inserted";
	}
	
	public Employee fetchEmployeeById(String email) {
		return employeeRepository.findById(email).get();
	}
	
	public List<Employee> fetchAllEmployee() {
		return employeeRepository.findAll();
	}
	
	public String deleteEmployeeById(String email) {
		employeeRepository.deleteById(email);
		return "Employee data deleted";
	}
	
	public String updateEmployeeById(String email, Employee employee) {
		Employee ExistingEmployee = employeeRepository.findById(email).get();
		
		ExistingEmployee.setName(employee.getName());
		ExistingEmployee.setSalary(employee.getSalary());
		ExistingEmployee.setDepartment(employee.getDepartment());
		
		employeeRepository.save(ExistingEmployee);
		
		return "Employee data updated successfully";
	}
}
