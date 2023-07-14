package com.educaweb.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educaweb.curso.entities.User;
import com.educaweb.curso.services.userService;

@RestController
@RequestMapping (value = "/users")
public class UserResource {
	@Autowired
	private userService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();		
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		return  ResponseEntity.ok().body(service.findById(id)) ;		
	}
	
	@PostMapping
	public ResponseEntity<User> insertUser(@RequestBody User obj){
		
		obj = service.indertUser(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);	
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void deleteUser(@PathVariable Long id ){
		
	User obj = service.findById(id);
	service.deleteUser(obj);
	}
	
	@PutMapping(value = "/update/{id}" )
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User newUserData ){
		User obj = service.findById(id);
		obj = service.updateUser(obj, newUserData);
		
		return ResponseEntity.ok().body(obj);
		
	}
	

}
