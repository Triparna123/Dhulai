package com.dhulai.controller;


import com.dhulai.entity.ServicesWash;
import com.dhulai.service.LaundryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ServicesController {

    @Autowired
    private LaundryService laundryService;

    @GetMapping("/getallservices")
    public ResponseEntity<List<ServicesWash>> getAllServices() {
        return new ResponseEntity<>(laundryService.getAllServices(),HttpStatus.OK);
    }
    // Add more endpoint methods as needed
}
