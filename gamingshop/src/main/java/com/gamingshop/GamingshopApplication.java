package com.gamingshop;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


import com.gamingshop.GamingshopApplication;
import com.gamingshop.domain.ShoppingCart;
import com.gamingshop.domain.User;
import com.gamingshop.domain.security.Role;
import com.gamingshop.domain.security.UserRole;
import com.gamingshop.service.UserService;
import com.gamingshop.utility.SecurityUtility;

@SpringBootApplication

public class GamingshopApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(GamingshopApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GamingshopApplication.class);
    }
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setIme("Igor");
		user1.setPrezime("Brdaric");
		user1.setUsername("korisnik");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("korisnik"));
		user1.setEmail("igorbrdaric@hotmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		ShoppingCart cart = new ShoppingCart();
		user1.setShoppingCart(cart);
		
		userService.createUser(user1, userRoles);
	}

}
