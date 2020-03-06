package com.adminportal_gamingshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminportal_gamingshop.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
