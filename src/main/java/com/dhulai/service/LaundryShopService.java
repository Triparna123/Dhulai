package com.dhulai.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.LaundryShopServices;
import com.dhulai.entity.LaundryShopWorkingTime;
import com.dhulai.entity.ServicesWash;
import com.dhulai.entity.ShopAdditionalDetails;
import com.dhulai.entity.ShopWithAdditionalDetails;
import com.dhulai.entity.WorkingDaysAndTime;
import com.dhulai.model.LaundryShopRequest;
import com.dhulai.model.LaundryShopWithServices;
import com.dhulai.repository.LaundryServiceRepository;
import com.dhulai.repository.LaundryShopRepository;
import com.dhulai.repository.LaundryShopWorkingTimeRepository;
import com.dhulai.repository.ServiceRepository;
import com.dhulai.repository.ShopAdditionalDetailRepo;
import com.dhulai.repository.ShopWithAdditionalDetailRepo;
import com.dhulai.repository.WorkingDaysAndTimeRepository;

import jakarta.transaction.Transactional;

@Service
public class LaundryShopService {

    @Autowired
    private LaundryShopRepository laundryShopRepository;

    @Autowired
    private LaundryServiceRepository laundryServiceRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ShopAdditionalDetailRepo shopAdditionalDetailRepo;
    @Autowired
    private ShopWithAdditionalDetailRepo shopWithAdditionalDetailRepo;

    @Autowired
    private LaundryShopWorkingTimeRepository laundryShopWorkingTimeRepository;

    @Autowired
    private WorkingDaysAndTimeRepository workingDaysAndTimeRepository;

    @Transactional
    public LaundryShopWithServices registerLaundryShopWithServices(LaundryShopWithServices laundryShopWithServices) {
        LaundryShop savedShop = laundryShopRepository.save(laundryShopWithServices.getLaundryShop());

        List<ServicesWash> savedServices = new ArrayList<>();
        if (laundryShopWithServices.getServices() != null) {
            for (ServicesWash service : laundryShopWithServices.getServices()) {
                ServicesWash savedService = serviceRepository.save(service);
                savedServices.add(savedService);

                LaundryShopServices laundryShopServices = new LaundryShopServices(savedShop, savedService);
                laundryServiceRepository.save(laundryShopServices);
            }
        }

        return new LaundryShopWithServices(savedShop, savedServices);
    }

    @Transactional
    public LaundryShop addAdditionalDetailsToShop(String shopName, LaundryShopRequest laundryShopRequest) {
    
        // Step 1: Fetch the LaundryShop entity using the shop name
        LaundryShop laundryShop = laundryShopRepository.findByName(shopName)
                .orElseThrow(() -> new RuntimeException(
                        "Laundry shop not found with name: " + shopName));
    
        // Step 2: Add or Update Shop Additional Details (Description and Ratings)
        ShopAdditionalDetails shopAdditionalDetails = laundryShopRequest.getShopAdditionalDetails();
        if (shopAdditionalDetails != null) {
            shopAdditionalDetails = shopAdditionalDetailRepo.save(shopAdditionalDetails);
    
            ShopWithAdditionalDetails shopWithAdditionalDetails = new ShopWithAdditionalDetails();
            shopWithAdditionalDetails.setLaundryShop(laundryShop);
            shopWithAdditionalDetails.setAdditionalDetails(shopAdditionalDetails);
    
            shopWithAdditionalDetailRepo.save(shopWithAdditionalDetails);
        }
    
        // Step 3: Add or Update Working Days and Times
        List<WorkingDaysAndTime> workingDaysAndTimes = laundryShopRequest.getWorkingDaysAndTimes();
        if (workingDaysAndTimes != null && !workingDaysAndTimes.isEmpty()) {
            for (WorkingDaysAndTime workingDayTime : workingDaysAndTimes) {
                workingDaysAndTimeRepository.save(workingDayTime);
    
                // Create the relationship between LaundryShop and WorkingDaysAndTime
                LaundryShopWorkingTime laundryShopWorkingTime = new LaundryShopWorkingTime();
                laundryShopWorkingTime.setLaundryShop(laundryShop);
                laundryShopWorkingTime.setWorkingDaysAndTime(workingDayTime);
    
                laundryShopWorkingTimeRepository.save(laundryShopWorkingTime);
            }
        }
    
        // Return the updated LaundryShop with additional details and working times
        return laundryShop;
    }
    

    public List<Map<String, Object>> getAllLaundryShops() {
        List<LaundryShop> shops = laundryShopRepository.findAll();
        
        return shops.stream().map(shop -> {
            Map<String, Object> shopData = new HashMap<>();
            shopData.put("shopId", shop.getShopId());
            shopData.put("name", shop.getName());
            shopData.put("address", shop.getAddress());

            // Fetch Services
            List<String> services = laundryShopServicesRepository.findByLaundryShop(shop).stream()
                .map(service -> service.getServicesWash().getServiceName())
                .collect(Collectors.toList());
            shopData.put("services", services);

            // Fetch Working Hours
            List<String> workingHours = laundryShopWorkingTimeRepository.findByLaundryShop(shop).stream()
                .map(wt -> wt.getWorkingDaysAndTime().getDay() + ": " + wt.getWorkingDaysAndTime().getOpenTime() + " - " + wt.getWorkingDaysAndTime().getCloseTime())
                .collect(Collectors.toList());
            shopData.put("workingHours", workingHours);

            // Fetch Additional Details (Description, Ratings)
            List<String> additionalDetails = shopWithAdditionalDetailsRepository.findByLaundryShop(shop).stream()
                .map(details -> details.getAdditionalDetails().getDescription())
                .collect(Collectors.toList());
            shopData.put("additionalDetails", additionalDetails);

            return shopData;
        }).collect(Collectors.toList());
    }

    public List<ServicesWash> getServicesByShopName(String shopName) {
        return laundryShopRepository.findServicesByShopName(shopName);
    }

    public LaundryShopWithServices getShopDetailsByName(String shopName) {
        LaundryShop laundryShop = laundryShopRepository.findByName(shopName)
                .orElseThrow(() -> new RuntimeException("Shop not found with name: " + shopName));
    
        List<ServicesWash> services = serviceRepository.findServicesByShopName(shopName);
    
        // Return the shop with the associated services
        return new LaundryShopWithServices(laundryShop, services);
    }
    
}
