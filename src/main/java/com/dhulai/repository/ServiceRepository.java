package com.dhulai.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.dhulai.entity.ServicesWash;

public interface ServiceRepository extends JpaRepository<ServicesWash, Long> {
    // Add custom queries or methods if needed
}
