package com.estates.project.controllers;

import com.estates.project.entities.Property;
import com.estates.project.services.PropertyService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    private PropertyService propertyService;
    @GetMapping("/property")
    public List<Property> getProperties(@RequestParam(required = false) String status,
                                        @RequestParam(required = false)String type,
                                        @RequestParam(required = false,defaultValue = "bedroom") String sort_by,
                                        @RequestParam(required = false, defaultValue = "DESC") String order){
         return this.propertyService.fetchProperties(status,type,sort_by,order);
    }

    @GetMapping("/property/{Id}")
    public Property getProperty(@PathVariable Integer Id){
        return this.propertyService.fetchPropertyById(Id);
    }

    @PostMapping("/property")
    public Property postProperty(@RequestBody Property property){
        return this.propertyService.createProperty(property);
    }
    @PatchMapping("/property/{Id}")
    public Property updateProperty(@PathVariable Integer Id, @RequestBody Property incompleteProperty){

        return this.propertyService.updateProperty(Id,incompleteProperty);
    }

    @DeleteMapping("/property/{Id}")
    public void deleteProperty(@PathVariable Integer Id){
        this.propertyService.removeProperty(Id);
    }
}

