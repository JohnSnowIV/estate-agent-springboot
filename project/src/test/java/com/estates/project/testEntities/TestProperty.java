package com.estates.project.testEntities;

import com.estates.project.entities.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



import static org.hamcrest.Matchers.hasProperty;


public class TestProperty {

    @Test
    public void testPropertyProperties(){
        Property newProperty= new Property();

        newProperty.setId(1);
        newProperty.setListed(true);
        newProperty.setAddress("23 Road");
        newProperty.setPostcode("EG56HD");

        Assertions.assertEquals(newProperty.getId(),1);
        Assertions.assertEquals(newProperty.getListed(),true);
        Assertions.assertEquals(newProperty.getAddress(),"23 Road");
        Assertions.assertEquals(newProperty.getPostcode(),"EG56HD");
    }

}
