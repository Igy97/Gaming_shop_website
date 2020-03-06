package com.gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamingshop.domain.Graphics_Card;

@Repository
public interface Graphics_Card_Repository extends CrudRepository<Graphics_Card, Long> {

}
