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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Table(name="PRODUCT")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRODUCT_ID")
    private int productId;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="QUANTITY")
    private int quantity;
    @Column(name="PRICE")
    private double price;
    @Column(name="ORIGINALPRICE")
    private double originalPrice;
    @Column(name="IMAGE_PATH")
    private String image;

    @ManyToOne
    @JoinColumn(name = "products")
    private LaundryShop laundryShop;
    
}
