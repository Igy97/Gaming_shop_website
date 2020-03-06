package com.gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamingshop.domain.Game;


@Repository
public interface GameRepository extends CrudRepository<Game, Long>{

}
