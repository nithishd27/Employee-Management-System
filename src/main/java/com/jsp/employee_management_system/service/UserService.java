package com.jsp.employee_management_system.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jsp.employee_management_system.dto.RegisterRequest;
import com.jsp.employee_management_system.entity.User;
import com.jsp.employee_management_system.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public String registerRequest(RegisterRequest registerRequest) {
		Optional<User> o= userRepository.findByEmail(registerRequest.getEmail());
		if(o.isPresent()) {
			return "Email already exists";
			
		}else {
			User user = new User();
			user.setName(registerRequest.getName());
			user.setEmail(registerRequest.getEmail());
			user.setPassword(registerRequest.getPassword());
			user.setRole("ROLE_USER");
			user.setVerified(false);
			userRepository.save(user);
			return "otp sent";
		}
	}

}
