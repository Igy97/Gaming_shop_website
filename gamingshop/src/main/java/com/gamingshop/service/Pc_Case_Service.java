package com.gamingshop.service;

import java.util.List;

import com.gamingshop.domain.Pc_Case;

public interface Pc_Case_Service {
	Pc_Case save(Pc_Case pc_case);

	List<Pc_Case> findAll();
	
	Pc_Case findOne(Long id);
	
	void removeOne(Long id);
}
