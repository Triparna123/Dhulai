package com.dhulai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dhulai.entity.LaundryShop;
import com.dhulai.enums.DaysOfWeek;
import com.dhulai.model.LaundryShopWithProducts;
import com.dhulai.model.LaundryShopWithServices;
import com.dhulai.model.LaundryShopWithWorkingDaysAndTime;
import com.dhulai.service.LaundryShopService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LaundryShopController {

    @Autowired
    private LaundryShopService laundryShopService;

    @GetMapping("/days")
    public ResponseEntity<List<DaysOfWeek>> getDays() {
        List<DaysOfWeek> days = Arrays.asList(DaysOfWeek.values());
        return ResponseEntity.ok(days);
    }

    @PostMapping("/savelaundryshop")
    public ResponseEntity<?> saveLaundryShop(@RequestBody LaundryShop laundryShop,
            @RequestBody LaundryShopWithProducts shopWithProducts,
            @RequestBody LaundryShopWithServices shopWithServices,
            @RequestBody LaundryShopWithWorkingDaysAndTime shopWithWorkingDaysAndTime) {
        try {
            // Save the shop and associated details using LaundryShopService
            LaundryShop savedShop = laundryShopService.saveShop(
                    laundryShop,
                    shopWithProducts,
                    shopWithServices,
                    shopWithWorkingDaysAndTime);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedShop);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while registering the laundry shop");
        }
    }

    @GetMapping("/getalllaundryshops")
    public ResponseEntity<List<Map<String, Object>>> getAllLaundryShopsWithServicesAndProducts() {
        List<Map<String, Object>> result = laundryShopService.getAllLaundryShopsWithServicesAndProducts();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
