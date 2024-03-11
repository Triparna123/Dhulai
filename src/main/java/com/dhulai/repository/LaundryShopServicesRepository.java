package com.dhulai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhulai.entity.LaundryShopServices;
import com.dhulai.model.LaundryShopServicesId;

public interface LaundryShopServicesRepository extends JpaRepository<LaundryShopServices,LaundryShopServicesId>{

}
