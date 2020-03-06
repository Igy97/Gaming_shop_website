package com.adminportal_gamingshop.service;

import java.util.List;

import com.adminportal_gamingshop.domain.Laptop;
import com.adminportal_gamingshop.domain.Processor;

public interface ProcessorService {
	Processor save(Processor  processor);

	List<Processor > findAll();
	
	Processor  findOne(Long id);
	
	void removeOne(Long id);
}
