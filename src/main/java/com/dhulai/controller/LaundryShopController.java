package com.dhulai.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.ServicesWash;
import com.dhulai.enums.DaysOfWeek;
import com.dhulai.model.LaundryShopRequest;
import com.dhulai.model.LaundryShopWithServices;
import com.dhulai.service.LaundryShopService;

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

    @PostMapping("/register")
    public ResponseEntity<LaundryShopWithServices> registerLaundryShop(
            @RequestBody LaundryShopWithServices laundryShopWithServices) {
        LaundryShopWithServices registeredShop = laundryShopService
                .registerLaundryShopWithServices(laundryShopWithServices);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredShop);
    }

    @PutMapping("/add-details/{shopName}")
    public ResponseEntity<?> addAdditionalDetailsToShop(
            @PathVariable String shopName,
            @RequestBody LaundryShopRequest laundryShopRequest) {
        try {
            // Call the service method to add additional details
            LaundryShop updatedShop = laundryShopService.addAdditionalDetailsToShop(shopName, laundryShopRequest);

            // Return the updated shop as the response
            return ResponseEntity.ok(updatedShop);
        } catch (RuntimeException e) {
            // Handle errors and return a meaningful response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // @GetMapping("/shopsWithServices")
    // public List<LaundryShopWithServices> getShopsWithServices() {
    // return laundryShopService.getShopsWithServices();
    // }

    @GetMapping("/get-details")
    public ResponseEntity<LaundryShopWithServices> getShopDetailsByName(@RequestParam String shopName) {
        try {
            LaundryShopWithServices shopWithServices = laundryShopService.getShopDetailsByName(shopName);
            return ResponseEntity.ok(shopWithServices);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    

    @GetMapping("/{shopName}/services")
    public List<ServicesWash> getServicesByShopName(@PathVariable String shopName) {
        return laundryShopService.getServicesByShopName(shopName);
    }
    @GetMapping("/getalllaundryshops")
    public ResponseEntity<List<Map<String, Object>>> getAllLaundryShops() {
        List<Map<String, Object>> shops = laundryShopService.getAllLaundryShops();
        return ResponseEntity.ok(shops);
    }

}
