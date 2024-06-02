package com.drn.userservice;

import com.drn.userservice.domain.Role;
import com.drn.userservice.domain.RoleName;
import com.drn.userservice.domain.User;
import com.drn.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}


	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, RoleName.ROLE_USER));
			userService.saveRole(new Role(null,RoleName.ROLE_MANAGER));
			userService.saveRole(new Role(null,RoleName.ROLE_ADMIN));
			userService.saveRole(new Role(null,RoleName.ROLE_SUPER_ADMIN));

			userService.saveUser(new User(null,"John", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Rambo", "rambo", "1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Ali", "ali123", "1234", new ArrayList<>()));
			userService.saveUser(new User(null,"Veli", "veli123", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", RoleName.ROLE_USER);
			userService.addRoleToUser("john", RoleName.ROLE_MANAGER);
			userService.addRoleToUser("rambo", RoleName.ROLE_ADMIN);
			userService.addRoleToUser("ali123", RoleName.ROLE_ADMIN);
			userService.addRoleToUser("ali123", RoleName.ROLE_MANAGER);
			userService.addRoleToUser("veli123", RoleName.ROLE_SUPER_ADMIN);
		};
	}

}
