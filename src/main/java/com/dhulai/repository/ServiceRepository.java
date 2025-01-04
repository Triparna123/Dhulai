package com.dhulai.repository;
// import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.ServicesWash;

public interface ServiceRepository extends JpaRepository<ServicesWash, Long> {
    // Add custom queries or methods if needed
    // List<ServicesWash> findByLaundryShop(LaundryShop laundryShop);

    @Query("SELECT s.servicesWash FROM LaundryShopServices s WHERE s.laundryShop.name = :shopName")
List<ServicesWash> findServicesByShopName(@Param("shopName") String shopName);




}
