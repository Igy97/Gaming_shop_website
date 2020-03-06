package com.adminportal_gamingshop.service;

import java.util.Set;

import com.adminportal_gamingshop.domain.User;
import com.adminportal_gamingshop.domain.security.UserRole;





public interface UserService {
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);
}
