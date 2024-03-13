package com.dhulai.model;

import java.util.List;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.ServicesWash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaundryShopWithServices {
    private LaundryShop laundryShop;
    private List<ServicesWash> services;

}
