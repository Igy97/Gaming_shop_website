package com.gamingshop.service;

import java.util.List;

import com.gamingshop.domain.Game;


public interface GameService {
	Game save(Game game);

	List<Game> findAll();
	
	Game findOne(Long id);
	
	void removeOne(Long id);
}
