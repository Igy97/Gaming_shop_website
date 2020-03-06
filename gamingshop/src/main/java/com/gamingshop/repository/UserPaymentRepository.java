package com.gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamingshop.domain.UserPayment;

@Repository
public interface UserPaymentRepository extends CrudRepository<UserPayment, Long>{

}
