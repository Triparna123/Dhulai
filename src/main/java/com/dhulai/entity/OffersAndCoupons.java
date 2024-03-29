package com.dhulai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "OFFERS_AND_COUPONS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class OffersAndCoupons {
    @Id
    private int offer_id;
   private String offers;
  private String couponCode;
  private String paymentMode;
}
