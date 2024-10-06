package com.property.PropertyService.service;



import com.property.PropertyService.entity.PropertyForSale;
import com.property.PropertyService.repository.PropertyForSaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PropertyForSaleService {

    @Autowired
    private PropertyForSaleRepo propertyForSaleRepository;

    // Save a new property
    public PropertyForSale saveProperty(PropertyForSale property) {
        return propertyForSaleRepository.save(property);
    }

    // Get all properties
    public List<PropertyForSale> getAllProperties() {
        return propertyForSaleRepository.findAll();
    }

    // Get a property by ID
    public PropertyForSale getPropertyById(int id) {
        return propertyForSaleRepository.findById(id).orElse(null);
    }

    // Delete a property by ID
    public String deleteProperty(int id) {
        propertyForSaleRepository.deleteById(id);
        return "Property removed with id " + id;
    }

    // Update a property
    public PropertyForSale updateProperty(PropertyForSale property) {
        PropertyForSale existingProperty = propertyForSaleRepository.findById(property.getId()).orElse(null);
        if (existingProperty != null) {
            existingProperty.setArea(property.getArea());
            existingProperty.setMinBed(property.getMinBed());
            existingProperty.setMaxPrice(property.getMaxPrice());
            existingProperty.setPropertyType(property.getPropertyType());
            return propertyForSaleRepository.save(existingProperty);
        }
        return null;
    }
}
