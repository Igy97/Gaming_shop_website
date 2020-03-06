package com.gamingshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.gamingshop.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{
	
}
