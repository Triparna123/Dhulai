package com.dhulai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.LaundryShopProducts;
import com.dhulai.entity.LaundryShopServices;
import com.dhulai.entity.Products;
import com.dhulai.entity.ServicesWash;
import com.dhulai.entity.WorkingDaysAndTime;
import com.dhulai.model.LaundryShopWithProducts;
import com.dhulai.model.LaundryShopWithServices;
import com.dhulai.model.LaundryShopWithWorkingDaysAndTime;
import com.dhulai.repository.LaundryProductRepository;
import com.dhulai.repository.LaundryServiceRepository;
import com.dhulai.repository.LaundryShopRepository;
import com.dhulai.repository.ProductRepository;
import com.dhulai.repository.ServiceRepository;
import com.dhulai.repository.WorkingDaysAndTimeRepository;

import jakarta.transaction.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
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
    private ProductRepository productRepository;
    @Autowired
    private WorkingDaysAndTimeRepository workingDaysAndTimeRepository;

    // @Transactional
    // public LaundryShop saveShop(LaundryShop laundryShop, LaundryShopWithProducts
    // shopWithProducts,
    // LaundryShopWithServices shopWithServices, LaundryShopWithWorkingDaysAndTime
    // shopWithWorkingDaysAndTime) {
    // // Save shop details
    // LaundryShop shop = laundryShopRepository.save(laundryShop);

    // // Save selected services for the shop
    // List<ServicesWash> servicesList = shopWithServices.getServices();
    // for (ServicesWash service : servicesList) {
    // LaundryShopServices shopService = new LaundryShopServices(shop, service);
    // laundryServiceRepository.save(shopService);
    // }

    // // Save selected products for the shop
    // List<Products> productList = shopWithProducts.getProducts();
    // for (Products product : productList) {
    // LaundryShopProducts shopProduct = new LaundryShopProducts(shop, product);
    // laundryProductRepository.save(shopProduct);
    // }

    // // Save working days and times for the shop
    // List<WorkingDaysAndTime> workingDaysAndTime =
    // shopWithWorkingDaysAndTime.getWorkingDaysAndTime();
    // for (WorkingDaysAndTime dayAndTime : workingDaysAndTime) {
    // dayAndTime.setShopId(shop);
    // workingDaysAndTimeRepository.save(dayAndTime);
    // }

    // return shop;
    // }
    @Transactional
    public LaundryShopWithServices registerLaundryShopWithServices(LaundryShopWithServices laundryShopWithServices) {
        // Save the LaundryShop to the database
        LaundryShop savedShop = laundryShopRepository.save(laundryShopWithServices.getLaundryShop());

        // Save each service in the list of services if it is not null
        List<ServicesWash> savedServices = new ArrayList<>();
        if (laundryShopWithServices.getServices() != null) {
            for (ServicesWash service : laundryShopWithServices.getServices()) {
                ServicesWash savedService = serviceRepository.save(service);
                savedServices.add(savedService);

                // Map the service to the laundry shop in the join table
                LaundryShopServices laundryShopServices = new LaundryShopServices(savedShop, savedService);
                laundryServiceRepository.save(laundryShopServices);
            }
        }

        // Return the saved shop with the services attached
        return new LaundryShopWithServices(savedShop, savedServices);
    }

    public List<LaundryShopWithServices> getShopsWithServices() {
        return laundryShopRepository.findShopsWithServices();
    }

    // @Transactional
    // public List<Map<String, Object>> getAllLaundryShopsWithServicesAndProducts() {
    //     List<LaundryShop> allLaundryShops = laundryShopRepository.findAll();

    //     return allLaundryShops.stream()
    //             .map(shop -> {
    //                 Map<String, Object> shopData = new HashMap<>();
    //                 shopData.put("shop", shop);
    //                 shopData.put("services", mapShopToModelService(shop).getServices());
    //                 shopData.put("products", mapShopToModelProducts(shop).getProducts());
    //                 shopData.put("workingDaysAndTime",
    //                         getAllWorkingDaysofAShop(shop).getWorkingDaysAndTime());
    //                 return shopData;
    //             })
    //             .collect(Collectors.toList());
    // }

    // private LaundryShopWithServices mapShopToModelService(LaundryShop laundryShop) {
    //     List<LaundryShopServices> servicesForShop = laundryServiceRepository.findByLaundryShop(laundryShop);
    //     List<ServicesWash> servicesList = servicesForShop.stream()
    //             .map(LaundryShopServices::getServicesWash)
    //             .collect(Collectors.toList());

    //     return new LaundryShopWithServices(laundryShop, servicesList);
    // }

    private LaundryShopWithProducts mapShopToModelProducts(LaundryShop laundryShop) {
        List<LaundryShopProducts> productsForShop = laundryProductRepository.findByLaundryShop(laundryShop);
        List<Products> productsList = productsForShop.stream()
                .map(LaundryShopProducts::getProducts)
                .collect(Collectors.toList());

        return new LaundryShopWithProducts(laundryShop, productsList);
    }

    private LaundryShopWithWorkingDaysAndTime getAllWorkingDaysofAShop(LaundryShop laundryShop) {
        return new LaundryShopWithWorkingDaysAndTime(laundryShop,
                workingDaysAndTimeRepository.findByShopId(laundryShop));
    }

}
