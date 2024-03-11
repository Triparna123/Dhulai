package com.dhulai.entity;

import java.util.List;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
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
public class LaundryShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shopId;
    private String name;
    private String timing;
    private String ratings;
    private double distance;
    private String imagePath;
    private String description;
    // @ElementCollection
    // @CollectionTable(name = "WORKING_DAYS_AND_TIME", joinColumns = @JoinColumn(name = "SHOP_ID"))
    // @MapKeyColumn(name = "DAY")
    // @Column(name = "TIME")
    // private Map<String, String> workingDaysAndTime;
    @OneToMany(mappedBy = "laundryShops")
    private List<ServicesWash> services;
    @OneToMany(mappedBy = "laundryShop")
    private List<Products> products;
}
