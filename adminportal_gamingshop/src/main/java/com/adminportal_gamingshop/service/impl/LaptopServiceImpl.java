package com.adminportal_gamingshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal_gamingshop.domain.Laptop;
import com.adminportal_gamingshop.repository.LaptopRepository;
import com.adminportal_gamingshop.service.LaptopService;


@Service
public class LaptopServiceImpl implements LaptopService {

	@Autowired
	private LaptopRepository laptoprepository;
	
	@Override
	public Laptop save(Laptop laptop) {
		return laptoprepository.save(laptop);
	}

	@Override
	public List<Laptop> findAll() {
		return (List<Laptop>)laptoprepository.findAll();
	}

	@Override
	public Laptop findOne(Long id) {
		return laptoprepository.findById(id).orElse(new Laptop());
	}

	@Override
	public void removeOne(Long id) {
		laptoprepository.deleteById(id);		
	}

}
