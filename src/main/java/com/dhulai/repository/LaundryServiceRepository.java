package com.dhulai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.LaundryShopServices;
import com.dhulai.entity.ServicesWash;
import com.dhulai.model.LaundryShopServicesId;

// LaundryServiceRepository.java
public interface LaundryServiceRepository extends JpaRepository<LaundryShopServices, LaundryShopServicesId> {
    // Add custom queries if needed
    List<LaundryShopServices> findByLaundryShop(LaundryShop laundryShop);

    LaundryShopServices findByLaundryShopAndServicesWash(LaundryShop laundryShop, ServicesWash servicesWash); // Add
                                                                                                              // this
                                                                                                              // line

    

}
