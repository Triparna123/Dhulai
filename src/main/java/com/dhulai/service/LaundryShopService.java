package com.dhulai.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhulai.entity.LaundryShop;
import com.dhulai.repository.LaundryShopRepository;

import java.util.List;

@Service
public class LaundryShopService {

    private final LaundryShopRepository laundryShopRepository;

    @Autowired
    public LaundryShopService(LaundryShopRepository laundryShopRepository) {
        this.laundryShopRepository = laundryShopRepository;
    }

    public LaundryShop saveLaundryShop(LaundryShop laundryShop) {
        return laundryShopRepository.save(laundryShop);
    }

    public List<LaundryShop> getAllLaundryShops() {
        return laundryShopRepository.findAll();
    }

    public LaundryShop getLaundryShopById(int shopId) {
        return laundryShopRepository.findById(shopId).orElse(null);
    }

    // Other methods as needed

    // public List<LaundryShop> getLaundryShopsByRatingGreaterThan(String rating) {
    //     return laundryShopRepository.findByRatingsGreaterThan(rating);
    // }

    // public List<LaundryShop> getLaundryShopsByDistanceLessThan(double distance) {
    //     return laundryShopRepository.findByDistanceLessThan(distance);
    // }
}
