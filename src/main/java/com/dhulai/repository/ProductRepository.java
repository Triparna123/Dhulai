package com.dhulai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhulai.entity.Products;

public interface ProductRepository extends JpaRepository<Products,Integer>{

    
} 
