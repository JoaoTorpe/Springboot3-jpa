package com.educaweb.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educaweb.curso.entities.User;
import com.educaweb.curso.repositories.userRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner{

	@Autowired
	private userRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456"); 

		userRepository.saveAll(Arrays.asList(u1,u2));
		
		
	}
	
}
