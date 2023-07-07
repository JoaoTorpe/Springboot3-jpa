package com.educaweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educaweb.curso.entities.User;

public interface userRepository extends JpaRepository<User, Long>{
	
	

}
