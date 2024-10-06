package com.property.PropertyService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity

public class PropertyToRent {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String area;
    private int minBed;
    private int maxPrice;

    private String propertyType;
}
