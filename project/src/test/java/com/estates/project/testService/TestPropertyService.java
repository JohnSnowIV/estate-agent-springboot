package com.estates.project.testService;


import com.estates.project.entities.Property;
import com.estates.project.repository.PropertyRepository;
import com.estates.project.services.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class TestPropertyService {

   @Mock
   private PropertyRepository propertyRepo;

   @InjectMocks
   private PropertyService propertyService;

    @Test
    public void testFindAllProperties(){
        Property testProp=new Property();
        testProp.setAddress("24 Here i am");
        List<Property> testList= List.of(testProp);
        when(this.propertyRepo.findAll()).thenReturn(testList);

        Assertions.assertEquals(propertyService.fetchProperties(null,null).size(),1);
        Assertions.assertEquals(propertyService.fetchProperties(null,null).get(0).getAddress(),"24 Here i am");

    }

    @Test
    public void testCreateProperty(){
        Property newProperty=new Property();
        newProperty.setAddress("road street");

        when(this.propertyRepo.save(newProperty)).thenReturn(newProperty);

        Assertions.assertEquals(propertyService.createProperty(newProperty),newProperty);
        Assertions.assertEquals(propertyService.createProperty(newProperty).getAddress(),"road street");
    }



}
