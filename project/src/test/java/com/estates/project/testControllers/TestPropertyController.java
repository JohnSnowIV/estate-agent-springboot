package com.estates.project.testControllers;

import com.estates.project.controllers.PropertyController;
import com.estates.project.entities.Property;
import com.estates.project.services.PropertyService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PropertyController.class)
public class TestPropertyController {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PropertyService propertyService;


    @Test
    public void testGetProperties() throws Exception{
        Property prop1= new Property();
        Property prop2=new Property();
        Property prop3=new Property();
        List<Property> propList= List.of(prop1,prop2,prop3);

        when(this.propertyService.fetchProperties()).thenReturn(propList);

        mvc.perform(MockMvcRequestBuilders.get("/properties"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)));
    }

}
