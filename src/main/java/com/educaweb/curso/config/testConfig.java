package com.educaweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educaweb.curso.entities.Category;
import com.educaweb.curso.entities.Order;
import com.educaweb.curso.entities.User;
import com.educaweb.curso.entities.enums.OrderStatus;
import com.educaweb.curso.repositories.CategoryRepository;
import com.educaweb.curso.repositories.orderRepository;
import com.educaweb.curso.repositories.userRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner{

	@Autowired
	private userRepository userRepository;
	@Autowired
	private orderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryReposotory;
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User("Alex Green", "alex@gmail.com", "977777777", "123456"); 

		
		Order o1 = new Order( Instant.parse("2019-06-20T19:53:07Z"), u1,OrderStatus.PAID);
		Order o2 = new Order (Instant.parse("2019-07-21T03:42:10Z"), u2,OrderStatus.DELIVERED);
		Order o3 = new Order( Instant.parse("2019-07-22T15:21:22Z"), u1,OrderStatus.PAID);
		
		Category cat1 = new Category("Electronics");
		Category cat2 = new Category( "Books");
		Category cat3 = new Category( "Computers"); 

		categoryReposotory.saveAll(Arrays.asList(cat1,cat2,cat3));
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		
	}
	
}
