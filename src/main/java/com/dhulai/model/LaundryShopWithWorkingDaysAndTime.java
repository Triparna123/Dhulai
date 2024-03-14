package com.dhulai.model;

import java.util.List;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.WorkingDaysAndTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaundryShopWithWorkingDaysAndTime {
    private LaundryShop laundryShop;
    private List<WorkingDaysAndTime> workingDaysAndTime;
}
