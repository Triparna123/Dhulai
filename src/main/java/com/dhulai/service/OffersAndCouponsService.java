package com.dhulai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhulai.entity.OffersAndCoupons;
import com.dhulai.repository.OffersAndCouponsRepository;

@Service
public class OffersAndCouponsService {

    @Autowired
    private OffersAndCouponsRepository offersAndCouponsRepository;
   
    public List<OffersAndCoupons> getAllOffers() {
        return offersAndCouponsRepository.findAll();
    }

}
