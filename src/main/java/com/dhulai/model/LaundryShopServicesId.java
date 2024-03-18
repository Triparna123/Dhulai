package com.dhulai.model;

import java.io.Serializable;

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
public class LaundryShopServicesId implements Serializable {

    private LaundryShop laundryShop;
    private ServicesWash servicesWash;

}
