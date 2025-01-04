package com.dhulai.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LAUNDRY_SHOP_ADDITIONAL_DETAILS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopWithAdditionalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "SHOP_ID")
    private LaundryShop laundryShop;

    @ManyToOne
    @JoinColumn(name = "DETAIL_ID")
    private ShopAdditionalDetails additionalDetails;

}
