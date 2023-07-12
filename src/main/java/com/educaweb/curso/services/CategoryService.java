package com.educaweb.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educaweb.curso.entities.Category;
import com.educaweb.curso.repositories.CategoryRepository;

@Service
public class CategoryService {

	
	@Autowired
	private CategoryRepository Repository;
	
	public List<Category> findAll(){
		
		return Repository.findAll();
		
	}
	
	
	public Category findById(Long id) {
		
		Optional<Category> Category =  Repository.findById(id);
		
		return Category.get();
	}
	
	
	
}
