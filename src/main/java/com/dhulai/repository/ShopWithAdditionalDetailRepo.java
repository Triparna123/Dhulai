package com.dhulai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhulai.entity.ShopWithAdditionalDetails;

public interface ShopWithAdditionalDetailRepo extends JpaRepository<ShopWithAdditionalDetails, Long> {

}
