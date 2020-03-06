package com.gamingshop.service;

import java.util.Set;

import com.gamingshop.domain.UserBilling;
import com.gamingshop.domain.UserPayment;
import com.gamingshop.domain.UserShipping;
import com.gamingshop.domain.User;

import com.gamingshop.domain.security.PasswordResetToken;
import com.gamingshop.domain.security.UserRole;

public interface UserService {
PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForUser(final User user, final String token);
	
	User findByUsername(String username);
	
	User findByEmail (String email);
	
	User findById(Long id);
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);
	
	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);
	
	void updateUserShipping(UserShipping userShipping, User user);
	
	void setUserDefaultPayment(Long userPaymentId, User user);
	
	void setUserDefaultShipping(Long userShippingId, User user);
	
}
