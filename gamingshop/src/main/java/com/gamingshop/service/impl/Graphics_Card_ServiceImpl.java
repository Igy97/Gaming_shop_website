package com.gamingshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamingshop.domain.Graphics_Card;
import com.gamingshop.repository.Graphics_Card_Repository;
import com.gamingshop.service.Graphics_Card_Service;


@Service
public class Graphics_Card_ServiceImpl implements Graphics_Card_Service {

	
	@Autowired
	Graphics_Card_Repository graphics_repository;
	
	@Override
	public Graphics_Card save(Graphics_Card card) {
		return  graphics_repository.save(card);
	}

	@Override
	public List<Graphics_Card> findAll() {
		return (List<Graphics_Card> )graphics_repository.findAll();
	}

	@Override
	public Graphics_Card findOne(Long id) {
		return graphics_repository.findById(id).orElse(new Graphics_Card());
	}

	@Override
	public void removeOne(Long id) {
		graphics_repository.deleteById(id);	
	}

}
