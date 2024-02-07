package com.example.service;


import com.example.entity.ServicesWash;
import com.example.repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaundryService {
    
    private final ServiceRepository serviceRepository;

    @Autowired
    public LaundryService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServicesWash> getAllServices() {
        return serviceRepository.findAll();
    }

    // Add more service methods as needed
}
