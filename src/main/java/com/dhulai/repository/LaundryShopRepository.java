package com.dhulai.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.ServicesWash;
import com.dhulai.model.LaundryShopWithServices;



public interface LaundryShopRepository extends JpaRepository<LaundryShop, Long> {
    
    /**
     * This method returns all shops along with their service list
     */
    @Query("SELECT new com.dhulai.model.LaundryShopWithServices(ls, sw) " +
    "FROM LaundryShop ls " +
    "JOIN LaundryShopServices lss ON ls.shopId = lss.laundryShop.shopId " +
    "JOIN ServicesWash sw ON lss.servicesWash.id = sw.id")
    List<LaundryShopWithServices> findShopsWithServices();

    /**
     * This method returns service list of a shop based on the shop name
     */
    @Query("SELECT s.servicesWash FROM LaundryShopServices s " +
       "JOIN s.servicesWash sw " +
       "WHERE s.laundryShop.name = :shopName")
List<ServicesWash> findServicesByShopName(@Param("shopName") String shopName);
   

    Optional<LaundryShop> findByName(String name);


    
   
}