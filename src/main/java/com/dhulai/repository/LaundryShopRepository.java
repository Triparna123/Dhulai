package com.dhulai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dhulai.entity.LaundryShop;
import com.dhulai.model.LaundryShopWithServices;

public interface LaundryShopRepository extends JpaRepository<LaundryShop, Long> {
    @Query("SELECT new com.dhulai.model.LaundryShopWithServices(ls.shopId, ls.name, ls.address, " +
    "GROUP_CONCAT(sw.serviceName)) " +
    "FROM LaundryShop ls " +
    "JOIN LaundryShopServices lss ON ls.shopId = lss.laundryShop.shopId " +
    "JOIN ServicesWash sw ON lss.servicesWash.serviceId = sw.serviceId " +
    "GROUP BY ls.shopId")
    List<LaundryShopWithServices> findShopsWithServices();

}