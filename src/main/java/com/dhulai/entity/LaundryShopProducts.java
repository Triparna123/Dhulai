package com.dhulai.entity;

import com.dhulai.model.LaundryShopProductsId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LAUNDRY_SHOP_PRODUCTS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(LaundryShopProductsId.class)
public class LaundryShopProducts {
    @Id
    @ManyToOne
    @JoinColumn(name = "SHOP_ID")
    private LaundryShop laundryShop;

    @Id
    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private Products products;
}
