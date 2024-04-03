package com.estates.project.testControllers;

import com.estates.project.controllers.PropertyController;
import com.estates.project.entities.Property;
import com.estates.project.repository.PropertyRepository;
import com.estates.project.services.PropertyService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.jayway.jsonpath.JsonPath;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.hibernate.jdbc.Expectation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.internal.matchers.GreaterThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPropertyController {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    @Transactional
    @Order(1)
    public void testGetProperties() throws Exception {


       MvcResult Result=mvc.perform(MockMvcRequestBuilders.get("/property"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
               .andReturn();
        String content = Result.getResponse().getContentAsString();

        List<Property> propList= mapper.readValue(content, new TypeReference<List<Property>>() {
        });

        for(int i=0;i<propList.size();i++){
            Assertions.assertNotNull(propList.get(i).getId());
        }

    }

    @Test
    @Transactional
    @Order(2)
    public void testGetPropertyById() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/property/1"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)));

    }


    @Test
    @Transactional
    @Order(2)
    public void testPostProperty() throws Exception {
        Property newProperty = new Property(true, "3 Inchcape Drive, Manchester", "M9 8JN", "DETACHED", 1000000, 3, 1, 1, 1, "SOLD",
                "https://media.istockphoto.com/id/1470006282/photo/for-sale-real-estate-sign-in-front-of-new-house.webp?b=1&s=170667a&w=0&k=20&c=yBoP5dTQZsTf8ZiPehFAnb1AQHc0tsedvN6FRdVmy6Q=",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        Property compareProperty = new Property(true, "3 Inchcape Drive, Manchester", "M9 8JN", "DETACHED", 1000000, 3, 1, 1, 1, "SOLD",
                "https://media.istockphoto.com/id/1470006282/photo/for-sale-real-estate-sign-in-front-of-new-house.webp?b=1&s=170667a&w=0&k=20&c=yBoP5dTQZsTf8ZiPehFAnb1AQHc0tsedvN6FRdVmy6Q=",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");
        compareProperty.setId(1);
        String reqBody = mapper.writeValueAsString(newProperty);
        String compareJSON = mapper.writeValueAsString(compareProperty);


        mvc.perform(MockMvcRequestBuilders.post("/property").content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());


    }

    @Test
    @Transactional
    @Order(3)
    public void testPatchProperty() throws Exception {


        Property property= new Property();
        property.setDescription("quaint little place for relaxing");
        String propJSON=mapper.writeValueAsString(property);
        mvc.perform(MockMvcRequestBuilders.patch("/property/1").contentType(MediaType.APPLICATION_JSON).content(propJSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description",Matchers.is("quaint little place for relaxing")));
    }

    @Test
    @Transactional
    @Order(4)
    public void testDeleteProperty() throws Exception{

        mvc.perform(MockMvcRequestBuilders.delete("/property/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mvc.perform(MockMvcRequestBuilders.get("/property/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());


    }

}
