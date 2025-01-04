package com.dhulai.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class ShopAdditionalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This will auto-generate the ID
    @Column(name = "DETAIL_ID")
    private Integer detailId;

    private String description;
    private List<String> ratings;

}
