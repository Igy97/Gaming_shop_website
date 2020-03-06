package com.adminportal_gamingshop.service;

import java.util.List;

import com.adminportal_gamingshop.domain.Graphics_Card;

public interface Graphics_Card_Service {
	
	Graphics_Card save(Graphics_Card card);

	List<Graphics_Card> findAll();
	
	Graphics_Card findOne(Long id);
	
	void removeOne(Long id);
}
