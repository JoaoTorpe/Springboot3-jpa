package com.educaweb.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educaweb.curso.entities.Order;

public interface orderRepository extends JpaRepository<Order, Long> {

}
