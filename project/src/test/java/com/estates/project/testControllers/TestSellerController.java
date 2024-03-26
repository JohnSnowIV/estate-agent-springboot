package com.estates.project.testControllers;

import com.estates.project.controllers.SellerController;

import com.estates.project.entities.Property;
import com.estates.project.entities.Seller;
import com.estates.project.services.SellerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class TestSellerController {

    //Initialising global newSeller
    Seller newSeller = new Seller("Brian", "McCloudy", "Box", "Beach", "123456789" );

    //Storing the postSeller as a variable to compare
    public static MvcResult postComp; //Used to compare the returned result of the remove test with created seller.
    @Autowired
    private SellerController sellerController;
    @Autowired
    private SellerService sellerService;

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    // Sanity test - checks that controller and service loads
    @Test
    void contextLoads() throws Exception {
        assertThat(sellerController).isNotNull();
        assertThat(sellerService).isNotNull();
    }

    @Test
//    @Transactional
    public void testGetSellers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/seller"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(7)));
    }

    @Test
//    @Transactional
    public void testGetSellerById() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/seller/1"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)));
    }
    @Test //Adds a new seller
//    @Transactional
    @Order(1)
    public void testPostSeller() throws Exception {
//        Seller newSeller = new Seller("Brian", "McCloudy", "Box", "Beach", "123456789" );
        Seller compareSeller = new Seller(8, "Brian", "McCloudy", "Box", "Beach", "123456789");
//        compareSeller.setId(8);

        String reqBody = mapper.writeValueAsString(newSeller);
        String compareJSON = mapper.writeValueAsString(compareSeller);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/seller")
                        .content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(8)))
                .andReturn();

        postComp = mvcResult;

        assertEquals(compareJSON, mvcResult.getResponse().getContentAsString());
    }

    @Test
//    @Transactional
    @Order(2)
    public void testPatchSeller() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/seller"))
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(print());

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("firstName", "Josie");

        mvc.perform(MockMvcRequestBuilders.patch("/seller/8").contentType(MediaType.APPLICATION_JSON).params(parameters))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName",Matchers.is("Josie")));
    }

    @Test
    @Order(3)
//    @Transactional
    public void testRemoveSeller() throws Exception {
//        Seller newSeller = new Seller("Brian", "McCloudy", "Box", "Beach", "123456789" );
//        String reqBody = mapper.writeValueAsString(newSeller);

//       MvcResult postRequest = mvc.perform(MockMvcRequestBuilders.post("/seller")
//                        .content(reqBody).contentType(MediaType.APPLICATION_JSON))
//                        .andExpect(MockMvcResultMatchers.status().isOk())
//                        .andDo(print())
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(8)))
//                        .andReturn();

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/seller/8")
                        .content(postComp.getResponse().getContentAsString()).contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(8)))
                        .andReturn();

        assertEquals(postComp.getResponse().getContentAsString(), mvcResult.getResponse().getContentAsString());
    }
}
