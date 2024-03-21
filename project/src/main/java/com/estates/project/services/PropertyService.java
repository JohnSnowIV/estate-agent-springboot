package com.estates.project.services;

import com.estates.project.entities.Property;
import com.estates.project.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepo;

    public List<Property> fetchProperties(){
        return this.propertyRepo.findAll();
    }



}
