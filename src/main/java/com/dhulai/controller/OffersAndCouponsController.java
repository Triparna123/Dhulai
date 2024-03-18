package com.dhulai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhulai.entity.OffersAndCoupons;
import com.dhulai.service.OffersAndCouponsService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OffersAndCouponsController {

     @Autowired
    private OffersAndCouponsService offersAndCouponsService;

    @GetMapping("/getalloffers")
    public ResponseEntity<List<OffersAndCoupons>> getAllOffers() {
        List<OffersAndCoupons> offers = offersAndCouponsService.getAllOffers();
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }
}
