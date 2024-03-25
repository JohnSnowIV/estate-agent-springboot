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
    public List<Property> getProperties(){
         return this.propertyService.fetchProperties();
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
    public Property updateProperty(@PathVariable Integer Id, @RequestParam(required = false) String address,@RequestParam(required = false) Boolean listed,
                                   @RequestParam(required = false) String postcode, @RequestParam(required = false) String type,
                                   @RequestParam(required = false) Integer price, @RequestParam(required = false) Integer bedroom,
                                   @RequestParam(required = false) Integer bathroom, @RequestParam(required = false) Integer garden,
                                   @RequestParam(required = false) Integer sellerId,@RequestParam(required = false) String status, @RequestParam(required = false) String image,
                                   @RequestParam(required = false)String description,
                                   @RequestParam(required = false) LocalDateTime dateAdded){

        return this.propertyService.updateProperty(Id,address,listed,postcode,type,price
                ,bedroom,bathroom,garden,sellerId,status,image,description,dateAdded);
    }

    @DeleteMapping("/property/{Id}")
    public void deleteProperty(@PathVariable Integer Id){
        this.propertyService.removeProperty(Id);
    }
}
