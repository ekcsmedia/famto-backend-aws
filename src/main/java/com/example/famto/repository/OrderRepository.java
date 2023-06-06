package com.example.famto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.famto.entity.Order;

@Repository

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	
}