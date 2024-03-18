package com.dhulai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.LaundryShopProducts;
import com.dhulai.entity.LaundryShopServices;
import com.dhulai.entity.LaundryShopWorkingDaysAndTime;
import com.dhulai.entity.Products;
import com.dhulai.entity.ServicesWash;
import com.dhulai.entity.WorkingDaysAndTime;
import com.dhulai.model.LaundryShopWithProducts;
import com.dhulai.model.LaundryShopWithServices;
import com.dhulai.model.LaundryShopWithWorkingDaysAndTime;
import com.dhulai.repository.LaundryProductRepository;
import com.dhulai.repository.LaundryServiceRepository;
import com.dhulai.repository.LaundryShopRepository;
import com.dhulai.repository.ServiceRepository;
import com.dhulai.repository.WorkingDaysAndTimeRepository;

import jakarta.transaction.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LaundryShopService {

    @Autowired
    private LaundryShopRepository laundryShopRepository;
    @Autowired
    private LaundryServiceRepository laundryServiceRepository;
    @Autowired
    private LaundryProductRepository laundryProductRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private WorkingDaysAndTimeRepository workingDaysAndTimeRepository;

    public LaundryShop saveLaundryShop(LaundryShop laundryShop, List<Long> selectedServiceIds) {
        LaundryShop savedShop = laundryShopRepository.save(laundryShop);

        if (selectedServiceIds != null && !selectedServiceIds.isEmpty()) {
            List<ServicesWash> selectedServices = serviceRepository.findAllById(selectedServiceIds);
            for (ServicesWash service : selectedServices) {
                LaundryShopServices shopService = new LaundryShopServices();
                shopService.setLaundryShop(savedShop);
                shopService.setServicesWash(service);
                laundryServiceRepository.save(shopService);
            }
        }

        return savedShop;
    }

    @Transactional
    public List<Map<String, Object>> getAllLaundryShopsWithServicesAndProducts() {
        List<LaundryShop> allLaundryShops = laundryShopRepository.findAll();

        return allLaundryShops.stream()
                .map(shop -> {
                    Map<String, Object> shopData = new HashMap<>();
                    shopData.put("shop", shop);
                    shopData.put("services", mapShopToModelService(shop).getServices());
                    shopData.put("products", mapShopToModelProducts(shop).getProducts());
                    shopData.put("workingDaysAndTime", mapShopToModelWorkingDaysAndTime(shop).getWorkingDaysAndTime());
                    return shopData;
                })
                .collect(Collectors.toList());
    }
 
    private LaundryShopWithServices mapShopToModelService(LaundryShop laundryShop) {
        List<LaundryShopServices> servicesForShop = laundryServiceRepository.findByLaundryShop(laundryShop);
        List<ServicesWash> servicesList = servicesForShop.stream()
                .map(LaundryShopServices::getServicesWash)
                .collect(Collectors.toList());

        return new LaundryShopWithServices(laundryShop, servicesList);
    }

    private LaundryShopWithProducts mapShopToModelProducts(LaundryShop laundryShop) {
        List<LaundryShopProducts> productsForShop = laundryProductRepository.findByLaundryShop(laundryShop);
        List<Products> productsList = productsForShop.stream()
                .map(LaundryShopProducts::getProducts)
                .collect(Collectors.toList());

        return new LaundryShopWithProducts(laundryShop, productsList);
    }

    private LaundryShopWithWorkingDaysAndTime mapShopToModelWorkingDaysAndTime(LaundryShop laundryShop) {
        List<LaundryShopWorkingDaysAndTime> daysAndTimes = workingDaysAndTimeRepository.findByLaundryShop(laundryShop);
        List<WorkingDaysAndTime> workingDaysList = daysAndTimes.stream()
                .map(LaundryShopWorkingDaysAndTime::getWorkingDaysAndTime)
                .collect(Collectors.toList());

        return new LaundryShopWithWorkingDaysAndTime(laundryShop, workingDaysList);
    }

}
