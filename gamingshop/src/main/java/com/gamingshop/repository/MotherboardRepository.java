package com.gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamingshop.domain.Motherboard;

@Repository
public interface MotherboardRepository extends CrudRepository<Motherboard, Long> {

}
