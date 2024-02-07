package com.example.controller;


import com.example.entity.ServicesWash;
import com.example.service.LaundryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServicesController {

    private final LaundryService laundryService;

    @Autowired
    public ServicesController(LaundryService laundryService) {
        this.laundryService = laundryService;
    }

    @GetMapping("/getallservices")
    public List<ServicesWash> getAllServices() {
        return laundryService.getAllServices();
    }

    @GetMapping(value="/hello")
    public ResponseEntity<String> hello() {
       String  response = "Hello, world!";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Add more endpoint methods as needed
}
