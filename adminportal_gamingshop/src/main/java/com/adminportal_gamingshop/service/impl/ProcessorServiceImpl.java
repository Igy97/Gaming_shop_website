package com.adminportal_gamingshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal_gamingshop.domain.Processor;
import com.adminportal_gamingshop.repository.ProcessorRepository;
import com.adminportal_gamingshop.service.ProcessorService;

@Service
public class ProcessorServiceImpl implements ProcessorService {

	@Autowired
	ProcessorRepository processor_repository;
	
	@Override
	public Processor save(Processor processor) {
		return processor_repository.save(processor);
	}

	@Override
	public List<Processor> findAll() {
		return (List<Processor>)processor_repository.findAll();
	}

	@Override
	public Processor findOne(Long id) {	
		return processor_repository.findById(id).orElse(new Processor());
	}

	@Override
	public void removeOne(Long id) {
		processor_repository.deleteById(id);	
	}

}
