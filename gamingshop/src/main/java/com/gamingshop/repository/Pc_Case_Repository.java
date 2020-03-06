package com.gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamingshop.domain.Pc_Case;

@Repository
public interface Pc_Case_Repository extends CrudRepository<Pc_Case, Long> {

}
