package com.estates.project.controllers;

import com.estates.project.entities.Property;
import com.estates.project.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;
    @GetMapping("/properties")
    public List<Property> getProperties(){
         return this.propertyService.fetchProperties();
    }
}
