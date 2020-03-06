package com.gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamingshop.domain.Laptop;

@Repository
public interface LaptopRepository extends CrudRepository<Laptop, Long> {

}
