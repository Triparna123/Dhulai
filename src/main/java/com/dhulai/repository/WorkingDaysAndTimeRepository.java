package com.dhulai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.WorkingDaysAndTime;

public interface WorkingDaysAndTimeRepository extends JpaRepository<WorkingDaysAndTime,Integer>{
    List<WorkingDaysAndTime> findByShopId(LaundryShop laundryShop);

}
