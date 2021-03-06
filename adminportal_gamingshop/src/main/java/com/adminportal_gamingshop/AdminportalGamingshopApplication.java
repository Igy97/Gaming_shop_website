package com.adminportal_gamingshop;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.adminportal_gamingshop.AdminportalGamingshopApplication;
import com.adminportal_gamingshop.domain.User;
import com.adminportal_gamingshop.domain.security.Role;
import com.adminportal_gamingshop.domain.security.UserRole;
import com.adminportal_gamingshop.service.UserService;
import com.adminportal_gamingshop.utility.SecurityUtility;


@SpringBootApplication
public class AdminportalGamingshopApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args)  {
		SpringApplication.run(AdminportalGamingshopApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdminportalGamingshopApplication.class);
    }
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setUsername("admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user1.setEmail("admin@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setRoleId(0);
		role1.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
	}

}
