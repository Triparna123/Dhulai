package com.dhulai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhulai.entity.Products;


public interface ProductRepository extends JpaRepository<Products,Long>{
    Optional<Products> findById(Long id);
    
} 
