package com.property.PropertyService.controller;

import com.property.PropertyService.entity.PropertyForSale;
import com.property.PropertyService.service.PropertyForSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties/sale")
public class PropertyForSaleController {

    @Autowired
    private PropertyForSaleService propertyForSaleService;

    // Save a new property
    @PostMapping("/add")
    public PropertyForSale addProperty(@RequestBody PropertyForSale property) {
        return propertyForSaleService.saveProperty(property);
    }

    // Get all properties
    @GetMapping("/all")
    public List<PropertyForSale> getAllProperties() {
        return propertyForSaleService.getAllProperties();
    }

    // Get a property by ID
    @GetMapping("/{id}")
    public ResponseEntity<PropertyForSale> getPropertyById(@PathVariable int id) {
        PropertyForSale property = propertyForSaleService.getPropertyById(id);
        return property != null ? ResponseEntity.ok(property) : ResponseEntity.notFound().build();
    }

    // Update a property
    @PutMapping("/update")
    public ResponseEntity<PropertyForSale> updateProperty(@RequestBody PropertyForSale property) {
        PropertyForSale updatedProperty = propertyForSaleService.updateProperty(property);
        return updatedProperty != null ? ResponseEntity.ok(updatedProperty) : ResponseEntity.notFound().build();
    }

    // Delete a property
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable int id) {
        return ResponseEntity.ok(propertyForSaleService.deleteProperty(id));
    }
}
