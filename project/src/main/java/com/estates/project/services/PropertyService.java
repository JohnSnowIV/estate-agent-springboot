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

        if(address!=null) toUpdate.setAddress(address);
        if(listed!=null) toUpdate.setListed(listed);
        if(postcode!=null) toUpdate.setPostcode(postcode);
        if(type!=null) toUpdate.setType(type);
        if(price!=null) toUpdate.setPrice(price);
        if(bedroom!=null) toUpdate.setBedroom(bedroom);
        if(bathroom!=null) toUpdate.setBathroom(bathroom);
        if(garden!=null) toUpdate.setGarden(garden);
        if(status!=null) toUpdate.setStatus(status);
        if(image!=null) toUpdate.setImage(image);
        if(description!=null) toUpdate.setDescription(description);
        if(dateAdded!=null) toUpdate.setDateAdded(dateAdded);
        if(sellerId!=null) toUpdate.setSellerId(sellerId);


        return this.propertyRepo.save(toUpdate);
    }



}
