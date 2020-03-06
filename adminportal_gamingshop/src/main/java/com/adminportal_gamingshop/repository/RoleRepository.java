package com.adminportal_gamingshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminportal_gamingshop.domain.security.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}
