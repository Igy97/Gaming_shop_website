package com.gamingshop.service;

import java.util.List;

import com.gamingshop.domain.Motherboard;

public interface MotherboarService {
	Motherboard save(Motherboard  motherboard);

	List<Motherboard > findAll();
	
	Motherboard  findOne(Long id);
	
	void removeOne(Long id);
}
