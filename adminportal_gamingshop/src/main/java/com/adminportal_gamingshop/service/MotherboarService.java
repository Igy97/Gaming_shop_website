package com.adminportal_gamingshop.service;

import java.util.List;

import com.adminportal_gamingshop.domain.Motherboard;

public interface MotherboarService {
	Motherboard save(Motherboard  motherboard);

	List<Motherboard > findAll();
	
	Motherboard  findOne(Long id);
	
	void removeOne(Long id);
}
