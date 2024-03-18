package com.dhulai.model;
import java.util.List;

import com.dhulai.entity.LaundryShop;
import com.dhulai.entity.Products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaundryShopWithProducts {
    private LaundryShop shops;
    private List<Products> products;
}
