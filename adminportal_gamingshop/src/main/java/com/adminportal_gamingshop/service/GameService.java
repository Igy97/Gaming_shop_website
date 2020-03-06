package com.adminportal_gamingshop.service;

import java.util.List;

import com.adminportal_gamingshop.domain.Game;


public interface GameService {
	Game save(Game game);

	List<Game> findAll();
	
	Game findOne(Long id);
	
	void removeOne(Long id);
}
