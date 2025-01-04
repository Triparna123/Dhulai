package com.dhulai.repository;

import com.dhulai.entity.LaundryShopWorkingTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaundryShopWorkingTimeRepository extends JpaRepository<LaundryShopWorkingTime,Long > {
}
