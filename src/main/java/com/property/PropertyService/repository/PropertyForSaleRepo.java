package com.property.PropertyService.repository;

import com.property.PropertyService.entity.PropertyForSale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyForSaleRepo extends JpaRepository<PropertyForSale,Integer> {
}
