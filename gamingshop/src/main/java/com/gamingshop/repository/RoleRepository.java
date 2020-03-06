package com.gamingshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamingshop.domain.security.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}
