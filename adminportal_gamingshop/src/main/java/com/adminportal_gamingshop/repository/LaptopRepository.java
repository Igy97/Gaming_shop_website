package com.adminportal_gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adminportal_gamingshop.domain.Laptop;

@Repository
public interface LaptopRepository extends CrudRepository<Laptop, Long> {

}
