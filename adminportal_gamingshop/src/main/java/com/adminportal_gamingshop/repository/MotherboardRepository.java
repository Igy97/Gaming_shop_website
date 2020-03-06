package com.adminportal_gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adminportal_gamingshop.domain.Motherboard;

@Repository
public interface MotherboardRepository extends CrudRepository<Motherboard, Long> {

}
