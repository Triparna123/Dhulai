package com.dhulai.entity;

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
@Table(name = "SERVICESWASH")
public class ServicesWash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SERVICE_ID")
    private Long id;

    @Column(name = "SERVICE_NAME")
    private String serviceName;
    @Column(name = "ICON_NAME")
    private String iconName;

    public ServicesWash(Long id) {
        this.id = id;
    }
}

