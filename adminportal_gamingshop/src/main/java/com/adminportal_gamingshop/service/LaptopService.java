package com.adminportal_gamingshop.service;

import java.util.List;

import com.adminportal_gamingshop.domain.Laptop;

public interface LaptopService {
	Laptop save(Laptop laptop);

	List<Laptop> findAll();
	
	Laptop findOne(Long id);
	
	void removeOne(Long id);
}
