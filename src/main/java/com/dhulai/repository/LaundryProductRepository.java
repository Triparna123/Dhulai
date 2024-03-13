package com.dhulai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.LaundryShopProducts;

public interface LaundryProductRepository extends JpaRepository<LaundryShopProducts, Long> {
    List<LaundryShopProducts> findByLaundryShop(LaundryShop laundryShop);
}
