package com.dhulai.controller;


import com.dhulai.entity.ServicesWash;
import com.dhulai.service.LaundryService;

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

    @Autowired
    private LaundryService laundryService;

    @GetMapping("/getallservices")
    public List<ServicesWash> getAllServices() {
        System.out.println("getiubihdfg");
        return laundryService.getAllServices();
    }

    @GetMapping(value="/hello")
    public ResponseEntity<String> hello() {
        System.out.println("hello");
       String  response = "Hello, world!";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Add more endpoint methods as needed
}
