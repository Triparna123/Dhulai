package com.dhulai.entity;

import com.dhulai.model.LaundryShopWorkingDaysAndTimeId;

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
@Table(name = "LAUNDRY_SHOP_WORKING_DAYS_AND_TIME")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@IdClass(LaundryShopWorkingDaysAndTimeId.class)
public class LaundryShopWorkingDaysAndTime {

    @Id
    @ManyToOne
    @JoinColumn(name = "SHOP_ID")
    private LaundryShop laundryShop;

    @Id
    @ManyToOne
    @JoinColumn(name = "WORKING_ID")
    private WorkingDaysAndTime workingDaysAndTime;
}
