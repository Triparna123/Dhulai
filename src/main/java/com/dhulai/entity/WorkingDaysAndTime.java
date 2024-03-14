package com.dhulai.entity;

import java.time.LocalTime;


import jakarta.persistence.Column;
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
@Table(name = "WORKING_DAYS_AND_TIME")
public class WorkingDaysAndTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORKING_ID")
    private int workingId;
    @Column(name = "DAYS")
    private String day;
    @Column(name = "OPEN_TIME")
    private LocalTime openTime;
    @Column(name = "CLOSE_TIME")
    private LocalTime closeTime;

}
