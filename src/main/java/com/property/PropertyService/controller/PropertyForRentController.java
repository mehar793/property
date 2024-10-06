package com.property.PropertyService.controller;

import com.property.PropertyService.entity.PropertyToRent;
import com.property.PropertyService.service.PropertyForRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rent-properties")
public class PropertyForRentController {

    @Autowired
    private PropertyForRentService propertyForRentService;

    // Save a new property
    @PostMapping("/add")
    public PropertyToRent addProperty(@RequestBody PropertyToRent property) {
        return propertyForRentService.saveProperty(property);
    }

    // Get all properties
    @GetMapping("/all")
    public List<PropertyToRent> getAllProperties() {
        return propertyForRentService.getAllProperties();
    }

    // Get a property by ID
    @GetMapping("/{id}")
    public ResponseEntity<PropertyToRent> getPropertyById(@PathVariable int id) {
        PropertyToRent property = propertyForRentService.getPropertyById(id);
        return property != null ? ResponseEntity.ok(property) : ResponseEntity.notFound().build();
    }

    // Update a property
    @PutMapping("/update")
    public ResponseEntity<PropertyToRent> updateProperty(@RequestBody PropertyToRent property) {
        PropertyToRent updatedProperty = propertyForRentService.updateProperty(property);
        return updatedProperty != null ? ResponseEntity.ok(updatedProperty) : ResponseEntity.notFound().build();
    }

    // Delete a property
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable int id) {
        return ResponseEntity.ok(propertyForRentService.deleteProperty(id));
    }
}
