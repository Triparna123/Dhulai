package com.dhulai.entity;

import com.dhulai.model.LaundryShopServicesId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LAUNDRY_SHOP_SERVICES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(LaundryShopServicesId.class)
public class LaundryShopServices {

    
    @Id
    @ManyToOne
    @JoinColumn(name = "SHOP_ID")
    private LaundryShop laundryShop;

    @Id
    @ManyToOne
    @JoinColumn(name = "SERVICE_ID")
    private ServicesWash servicesWash;    
}
