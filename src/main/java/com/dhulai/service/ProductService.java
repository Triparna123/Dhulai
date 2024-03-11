package com.dhulai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhulai.entity.Products;

import com.dhulai.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        System.out.println(productRepository.findAll());
        return productRepository.findAll();
    }
}
