package com.gamingshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamingshop.domain.UserPayment;
import com.gamingshop.repository.UserPaymentRepository;
import com.gamingshop.service.UserPaymentService;

@Service
public class UserPaymentServiceImpl implements UserPaymentService{

	@Autowired
	private UserPaymentRepository userPaymentRepository;
		
	public UserPayment findById(Long id) {
		return userPaymentRepository.findById(id).orElse(new UserPayment());
	}
	
	public void removeById(Long id) {
		userPaymentRepository.deleteById(id);
	}
} 
