package com.educaweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educaweb.curso.entities.Category;
import com.educaweb.curso.entities.Order;
import com.educaweb.curso.entities.OrderItem;
import com.educaweb.curso.entities.Payment;
import com.educaweb.curso.entities.Product;
import com.educaweb.curso.entities.User;
import com.educaweb.curso.entities.enums.OrderStatus;
import com.educaweb.curso.repositories.CategoryRepository;
import com.educaweb.curso.repositories.ProductRepository;
import com.educaweb.curso.repositories.orderItemRepository;
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
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private orderItemRepository orderItemRepository;
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
		
		Product p1 = new Product("The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product("Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product("Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product("PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product("Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		categoryReposotory.saveAll(Arrays.asList(cat1,cat2,cat3));
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat3);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay1 = new Payment(Instant.parse("2019-06-20T21:53:07Z"),o1);
		o1.setPayment(pay1);
		orderRepository.save(o1);
		
		
		
	}
	
}
