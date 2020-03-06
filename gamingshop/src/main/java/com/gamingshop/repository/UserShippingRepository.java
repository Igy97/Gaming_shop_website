package com.gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamingshop.domain.UserShipping;

@Repository
public interface UserShippingRepository extends CrudRepository<UserShipping, Long> {
	
	

}
