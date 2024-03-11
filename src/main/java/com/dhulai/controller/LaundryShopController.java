package com.dhulai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dhulai.entity.LaundryShop;
import com.dhulai.service.LaundryShopService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LaundryShopController {

    private final LaundryShopService laundryShopService;

    @Autowired
    public LaundryShopController(LaundryShopService laundryShopService) {
        this.laundryShopService = laundryShopService;
    }

    @PostMapping
    public ResponseEntity<LaundryShop> createLaundryShop(@RequestBody LaundryShop laundryShop) {
        LaundryShop savedShop = laundryShopService.saveLaundryShop(laundryShop);
        return new ResponseEntity<>(savedShop, HttpStatus.CREATED);
    }

    @GetMapping("/getalllaundryshops")
    public ResponseEntity<List<LaundryShop>> getAllLaundryShops() {
        List<LaundryShop> laundryShops = laundryShopService.getAllLaundryShops();
        return new ResponseEntity<>(laundryShops, HttpStatus.OK);
    }

    @GetMapping("/{shopId}")
    public ResponseEntity<LaundryShop> getLaundryShopById(@PathVariable int shopId) {
        LaundryShop laundryShop = laundryShopService.getLaundryShopById(shopId);
        return laundryShop != null ?
                new ResponseEntity<>(laundryShop, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Other endpoints as needed

    // @GetMapping("/by-rating")
    // public ResponseEntity<List<LaundryShop>> getLaundryShopsByRatingGreaterThan(@RequestParam String rating) {
    //     List<LaundryShop> laundryShops = laundryShopService.getLaundryShopsByRatingGreaterThan(rating);
    //     return new ResponseEntity<>(laundryShops, HttpStatus.OK);
    // }

    // @GetMapping("/by-distance")
    // public ResponseEntity<List<LaundryShop>> getLaundryShopsByDistanceLessThan(@RequestParam double distance) {
    //     List<LaundryShop> laundryShops = laundryShopService.getLaundryShopsByDistanceLessThan(distance);
    //     return new ResponseEntity<>(laundryShops, HttpStatus.OK);
    // }
}
