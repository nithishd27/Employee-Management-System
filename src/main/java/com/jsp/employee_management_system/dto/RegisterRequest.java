package com.jsp.employee_management_system.dto;

import lombok.Data;

@Data
public class RegisterRequest {
	private String name;
	private String email;
	private String password;

}
