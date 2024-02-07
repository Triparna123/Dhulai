package com.dhulai.service;


import com.dhulai.entity.ServicesWash;
import com.dhulai.repository.ServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaundryService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServicesWash> getAllServices() {
        return serviceRepository.findAll();
    }

    // Add more service methods as needed
}
