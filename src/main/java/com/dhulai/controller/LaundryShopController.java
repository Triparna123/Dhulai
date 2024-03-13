package com.dhulai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dhulai.entity.LaundryShop;
import com.dhulai.model.LaundryShopWithServices;
import com.dhulai.service.LaundryShopService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LaundryShopController {

    @Autowired
    private LaundryShopService laundryShopService;

    @PostMapping("/savelaundryshop")
    public ResponseEntity<LaundryShop> createLaundryShop(@RequestBody LaundryShop laundryShop,
            @RequestParam List<Long> selectedServiceIds) {
        LaundryShop savedShop = laundryShopService.saveLaundryShop(laundryShop, selectedServiceIds);
        return new ResponseEntity<>(savedShop, HttpStatus.CREATED);
    }

    @GetMapping("/getalllaundryshops")
    public ResponseEntity<List<Map<String, Object>>> getAllLaundryShopsWithServicesAndProducts() {
        List<Map<String, Object>> result = laundryShopService.getAllLaundryShopsWithServicesAndProducts();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
