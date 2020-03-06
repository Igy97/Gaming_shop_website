package com.adminportal_gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adminportal_gamingshop.domain.Game;


@Repository
public interface GameRepository extends CrudRepository<Game, Long>{

}
