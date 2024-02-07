package com.example.repository;

import com.example.entity.ServicesWash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServicesWash, Integer> {
    // Add custom queries or methods if needed
}
