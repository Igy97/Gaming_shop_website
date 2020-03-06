package com.adminportal_gamingshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal_gamingshop.domain.Motherboard;
import com.adminportal_gamingshop.repository.MotherboardRepository;
import com.adminportal_gamingshop.service.MotherboarService;

@Service
public class MotherboarServiceImpl implements MotherboarService {

	@Autowired
	MotherboardRepository motherboard_repository;
	
	@Override
	public Motherboard save(Motherboard motherboard) {
		return motherboard_repository.save(motherboard);
	}

	@Override
	public List<Motherboard> findAll() {
		return (List<Motherboard>)motherboard_repository.findAll();
	}

	@Override
	public Motherboard findOne(Long id) {
		return motherboard_repository.findById(id).orElse(new Motherboard());
	}

	@Override
	public void removeOne(Long id) {
		motherboard_repository.deleteById(id);
		
	}

}
