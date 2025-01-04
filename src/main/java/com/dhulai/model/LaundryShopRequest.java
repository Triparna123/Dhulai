package com.dhulai.model;

import java.util.List;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.ServicesWash;
import com.dhulai.entity.ShopAdditionalDetails;
import com.dhulai.entity.WorkingDaysAndTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LaundryShopRequest {
    private LaundryShop laundryShop;
    private List<ServicesWash> serviceWash;
    private ShopAdditionalDetails shopAdditionalDetails;

    private List<WorkingDaysAndTime> workingDaysAndTimes;
 
    // Getters and Setters
}
