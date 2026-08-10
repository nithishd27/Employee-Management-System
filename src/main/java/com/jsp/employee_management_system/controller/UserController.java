package com.jsp.employee_management_system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.employee_management_system.dto.RegisterRequest;
import com.jsp.employee_management_system.dto.VerifyOtpRequest;
import com.jsp.employee_management_system.service.OtpVerifyService;
import com.jsp.employee_management_system.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	private OtpVerifyService otpVerifyService;
	
	
	public UserController(UserService userService, OtpVerifyService otpVerifyService) {
		this.userService = userService;
		this.otpVerifyService = otpVerifyService;
	}

	@PostMapping("/register")
	public String registerRequest(@RequestBody RegisterRequest registerRequest) {
		return userService.registerRequest(registerRequest);
	}
	
	@PostMapping("/verify-otp")
	public String otpVerification(@RequestBody VerifyOtpRequest verifyOtpRequest) {
		return otpVerifyService.otpverification(verifyOtpRequest);
		
	}

}
