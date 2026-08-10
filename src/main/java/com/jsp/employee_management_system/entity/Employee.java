package com.jsp.employee_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@Email
	private String email;
	@NotBlank
	private String name;
	@NotNull
	private double salary;
	@NotBlank
	private String department;
}
