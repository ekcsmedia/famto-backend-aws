package com.example.famto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.famto.entity.CustomerData;
import com.example.famto.entity.RestaurantData;

@Repository

public interface RestaurantRepo extends JpaRepository<RestaurantData, Integer>{

}
