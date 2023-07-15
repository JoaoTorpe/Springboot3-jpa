package com.educaweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaweb.curso.entities.User;
import com.educaweb.curso.repositories.userRepository;
import com.educaweb.curso.services.exeptions.ResourceNotFoundExption;
@Service
public class userService {

	
	@Autowired
	private userRepository Repository;
	
	public List<User> findAll(){
		
		return Repository.findAll();
		
	}
	
	
	public User findById(Long id) {
		
		Optional<User> user =  Repository.findById(id);
		
		return user.orElseThrow( () -> new ResourceNotFoundExption(id));
	}
	
	public User indertUser(User user) {
		
		return Repository.save(user);
		
	}
	
	public void deleteUser(User user) {
		
		Repository.delete(user);	
	}
	
	public User updateUser(User user,User newUserData) {
		user.setName(newUserData.getName());
		user.setEmail(newUserData.getEmail());
		user.setPhone(newUserData.getPhone());
		
		Repository.save(user);
		return user;
		
	}
	
	
}
