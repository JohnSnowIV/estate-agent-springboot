package com.estates.project.services;

import com.estates.project.entities.Property;
import com.estates.project.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepo;

    public List<Property> fetchProperties(String status, String type,String sort_by,String order){
        List<Property> toReturn= new ArrayList<>();
        if(order==null || order.equals("null")){
            order="desc";
        }
        if(sort_by==null || sort_by.equals("null")){
            sort_by="bedroom";
        }
        order=order.toUpperCase();
        if(type!=null) type=type.toLowerCase();
        if(status!=null) status=status.toLowerCase();
        sort_by=sort_by.toLowerCase();

        if(status!=null && status.equals("for_sale")){
            toReturn.addAll(this.propertyRepo.findForSale(Sort.by(order.equals("ASC")?Sort.Direction.ASC:Sort.Direction.DESC, sort_by)));
        }
        else if(status!=null && status.equals("sold")){
            toReturn.addAll(this.propertyRepo.findSold(Sort.by(order.equals("ASC")?Sort.Direction.ASC:Sort.Direction.DESC, sort_by)));
        }
        else if(type!=null && type.equals("detached")){
            toReturn.addAll(this.propertyRepo.findDetached(Sort.by(order.equals("ASC")?Sort.Direction.ASC:Sort.Direction.DESC, sort_by)));
        }
         else if(type!=null && type.equals("semi-detached")){
            toReturn.addAll(this.propertyRepo.findSemiDetached(Sort.by(order.equals("ASC")?Sort.Direction.ASC:Sort.Direction.DESC, sort_by)));
        }
        else if(type!=null && type.equals("terrace")){
            toReturn.addAll(this.propertyRepo.findTerrace(Sort.by(order.equals("ASC")?Sort.Direction.ASC:Sort.Direction.DESC, sort_by)));
        }
        else if(type!=null && type.equals("apartment")){
            toReturn.addAll(this.propertyRepo.findApartment(Sort.by(order.equals("ASC")?Sort.Direction.ASC:Sort.Direction.DESC, sort_by)));
        }

        else if(order.equals("ASC")){
            toReturn.addAll(this.propertyRepo.findAll(Sort.by(Sort.Direction.ASC, sort_by)));
        }
        else if(order.equals("DESC") ){
            toReturn.addAll(this.propertyRepo.findAll(Sort.by(Sort.Direction.DESC, sort_by)));
        }

        return toReturn;

    }


    public Property createProperty(Property property){
        return this.propertyRepo.save(property);
    }

    public Property fetchPropertyById(Integer Id){
        return this.propertyRepo.findById(Id).get();
    }

    public Property updateProperty(Integer Id, Property property){

        Property toUpdate=this.fetchPropertyById(Id);

        if(property.getAddress()!=null) toUpdate.setAddress(property.getAddress());
        if(property.getListed()!=null) toUpdate.setListed(property.getListed());
        if(property.getPostcode()!=null) toUpdate.setPostcode(property.getPostcode());
        if(property.getType()!=null) toUpdate.setType(property.getType());
        if(property.getPrice()!=null) toUpdate.setPrice(property.getPrice());
        if(property.getBedroom()!=null) toUpdate.setBedroom(property.getBedroom());
        if(property.getBedroom()!=null) toUpdate.setBathroom(property.getBedroom());
        if(property.getGarden()!=null) toUpdate.setGarden(property.getGarden());
        if(property.getStatus()!=null) toUpdate.setStatus(property.getStatus());
        if(property.getImage()!=null) toUpdate.setImage(property.getImage());
        if(property.getDescription()!=null) toUpdate.setDescription(property.getDescription());
        if(property.getDateAdded()!=null) {
            toUpdate.setDateAdded(property.getDateAdded());
        }
        if(property.getSellerId()!=null) toUpdate.setSellerId(property.getSellerId());


        return this.propertyRepo.save(toUpdate);
    }

    public void removeProperty(Integer Id){
          this.propertyRepo.deleteById(Id);
    }

}
