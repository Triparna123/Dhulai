package com.dhulai.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class WorkingDaysAndTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String day;
    private LocalTime openTime;
    private LocalTime closeTime;

}
