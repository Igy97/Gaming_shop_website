package com.gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamingshop.domain.Processor;

@Repository
public interface ProcessorRepository extends CrudRepository<Processor, Long>{

}
