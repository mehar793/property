package com.property.PropertyService.service;

import com.property.PropertyService.entity.PropertyToRent;
import com.property.PropertyService.repository.PropertyToRentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropertyForRentService {

    @Autowired
    private PropertyToRentRepo propertyForRentRepository;

    // Save a new property
    public PropertyToRent saveProperty(PropertyToRent property) {
        return propertyForRentRepository.save(property);
    }

    // Get all properties
    public List<PropertyToRent> getAllProperties() {
        return propertyForRentRepository.findAll();
    }

    // Get a property by ID
    public PropertyToRent getPropertyById(int id) {
        return propertyForRentRepository.findById(id).orElse(null);
    }

    // Delete a property by ID
    public String deleteProperty(int id) {
        propertyForRentRepository.deleteById(id);
        return "Property removed with id " + id;
    }

    // Update a property
    public PropertyToRent updateProperty(PropertyToRent property) {
        PropertyToRent existingProperty = propertyForRentRepository.findById(property.getId()).orElse(null);
        if (existingProperty != null) {
            existingProperty.setArea(property.getArea());
            existingProperty.setMinBed(property.getMinBed());
            existingProperty.setPropertyType(property.getPropertyType());
            return propertyForRentRepository.save(existingProperty);
        }
        return null;
    }
}

