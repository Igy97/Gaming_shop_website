package com.gamingshop.service;

import java.util.List;

import com.gamingshop.domain.Laptop;

public interface LaptopService {
	Laptop save(Laptop laptop);

	List<Laptop> findAll();
	
	Laptop findOne(Long id);
	
	void removeOne(Long id);
}
