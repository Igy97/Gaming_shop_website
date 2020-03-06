package com.adminportal_gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adminportal_gamingshop.domain.Graphics_Card;

@Repository
public interface Graphics_Card_Repository extends CrudRepository<Graphics_Card, Long> {

}
