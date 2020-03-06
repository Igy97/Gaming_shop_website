package com.gamingshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamingshop.domain.Game;
import com.gamingshop.domain.Laptop;
import com.gamingshop.repository.GameRepository;
import com.gamingshop.repository.LaptopRepository;
import com.gamingshop.service.GameService;
import com.gamingshop.service.LaptopService;


@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gamerepository;

	@Override
	public Game save(Game game) {
		return gamerepository.save(game);
	}

	@Override
	public List<Game> findAll() {
		return (List<Game>)gamerepository.findAll();
	}

	@Override
	public Game findOne(Long id) {
		return gamerepository.findById(id).orElse(new Game());
	}

	@Override
	public void removeOne(Long id) {
		gamerepository.deleteById(id);	
	}
	
	

}
