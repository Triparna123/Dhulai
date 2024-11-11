package com.dhulai.model;

import com.dhulai.entity.LaundryShop;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LaundryShopRequest {
    private LaundryShop laundryShop;
    private LaundryShopWithProducts shopWithProducts;
    private LaundryShopWithServices shopWithServices;
    private LaundryShopWithWorkingDaysAndTime shopWithWorkingDaysAndTime;

    // Getters and Setters
}
