package com.gamingshop.service;

import java.util.List;

import com.gamingshop.domain.Laptop;
import com.gamingshop.domain.Processor;

public interface ProcessorService {
	Processor save(Processor  processor);

	List<Processor > findAll();
	
	Processor  findOne(Long id);
	
	void removeOne(Long id);
}
