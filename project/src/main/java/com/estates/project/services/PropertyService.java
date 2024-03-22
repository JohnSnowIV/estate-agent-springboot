package com.estates.project.services;

import com.estates.project.entities.Property;
import com.estates.project.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepo;

    public List<Property> fetchProperties(){
        return this.propertyRepo.findAll();
    }

    public Property createProperty(Property property){
        return this.propertyRepo.save(property);
    }

    public Property fetchPropertyById(Integer Id){
        return this.propertyRepo.findById(Id).get();
    }

    public Property updateProperty(Integer Id, String address, Boolean listed, String postcode, String type,
                                   Integer price, Integer bedroom, Integer bathroom, Integer garden,
                                   Integer sellerId, String status, String image, String description,
                                   LocalDateTime dateAdded){

        Property toUpdate=this.fetchPropertyById(Id);


        return toUpdate;
    }



}
