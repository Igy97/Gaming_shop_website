package com.adminportal_gamingshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal_gamingshop.domain.Pc_Case;
import com.adminportal_gamingshop.repository.Pc_Case_Repository;
import com.adminportal_gamingshop.service.Pc_Case_Service;

@Service
public class Pc_Case_ServiceImpl implements Pc_Case_Service {

	@Autowired
	Pc_Case_Repository pc_case_repository;
	
	@Override
	public Pc_Case save(Pc_Case pc_case) {
		return pc_case_repository.save(pc_case);
	}

	@Override
	public List<Pc_Case> findAll() {
		return (List<Pc_Case>)pc_case_repository.findAll();
	}

	@Override
	public Pc_Case findOne(Long id) {
		return pc_case_repository.findById(id).orElse(new Pc_Case());
	}

	@Override
	public void removeOne(Long id) {
		pc_case_repository.deleteById(id);
	}

}
