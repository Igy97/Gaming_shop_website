package com.gamingshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamingshop.domain.UserShipping;
import com.gamingshop.repository.UserShippingRepository;
import com.gamingshop.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService{
	
	@Autowired
	private UserShippingRepository userShippingRepository;
	
	
	public UserShipping findById(Long id) {
		return userShippingRepository.findById(id).orElse(new UserShipping());
	}
	
	public void removeById(Long id) {
		userShippingRepository.deleteById(id);
	}

}
