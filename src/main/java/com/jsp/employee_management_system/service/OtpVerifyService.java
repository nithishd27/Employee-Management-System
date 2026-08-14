package com.jsp.employee_management_system.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jsp.employee_management_system.dto.VerifyOtpRequest;
import com.jsp.employee_management_system.entity.User;
import com.jsp.employee_management_system.exception.InvalidOtpException;
import com.jsp.employee_management_system.exception.OtpExpireException;
import com.jsp.employee_management_system.exception.UserNotFoundException;
import com.jsp.employee_management_system.repository.UserRepository;

@Service
public class OtpVerifyService {
	private UserRepository userRepository;

	public OtpVerifyService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public String otpverification(VerifyOtpRequest verifyOtpRequest) {
		Optional<User> optional= userRepository.findByEmail(verifyOtpRequest.getEmail());
		if(optional.isPresent()) {
			User user=optional.get();
			if(!user.getOtp().equals(verifyOtpRequest.getOtp())) {
				throw new InvalidOtpException("Invalid OTP");
			}
			if(LocalDateTime.now().isAfter(user.getOtpExpiryTime())) {
				throw new OtpExpireException("OTP Expired");
			}else {
				user.setVerified(true);
				user.setOtp(null);
				user.setOtpExpiryTime(null);
				userRepository.save(user);
				return "otp verified successfully";
			}
		}else {
			throw new UserNotFoundException("no user found");
		}
	}

}
