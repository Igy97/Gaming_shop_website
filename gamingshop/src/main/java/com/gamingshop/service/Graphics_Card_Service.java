package com.gamingshop.service;

import java.util.List;

import com.gamingshop.domain.Graphics_Card;

public interface Graphics_Card_Service {
	
	Graphics_Card save(Graphics_Card card);

	List<Graphics_Card> findAll();
	
	Graphics_Card findOne(Long id);
	
	void removeOne(Long id);
}
