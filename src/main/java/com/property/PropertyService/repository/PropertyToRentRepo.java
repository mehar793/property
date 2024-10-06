package com.property.PropertyService.repository;

import com.property.PropertyService.entity.PropertyToRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyToRentRepo  extends JpaRepository<PropertyToRent,Integer> {
}
