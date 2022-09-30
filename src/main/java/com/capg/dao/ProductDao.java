package com.capg.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.capg.model.Product;

public interface ProductDao extends JpaRepository<Product, Long>{
    @Query("SELECT p FROM Product p WHERE p.name LIKE :n")
    List<Product> findByName(@Param("n") String name);
	}
