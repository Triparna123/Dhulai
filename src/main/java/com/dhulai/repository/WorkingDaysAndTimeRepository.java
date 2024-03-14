package com.dhulai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.LaundryShopWorkingDaysAndTime;
import com.dhulai.model.LaundryShopWorkingDaysAndTimeId;

public interface WorkingDaysAndTimeRepository extends JpaRepository<LaundryShopWorkingDaysAndTime,LaundryShopWorkingDaysAndTimeId>{
    List<LaundryShopWorkingDaysAndTime> findByLaundryShop(LaundryShop laundryShop);

}
