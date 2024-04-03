package com.estates.project.testControllers;

import com.estates.project.controllers.SellerController;

import com.estates.project.entities.Seller;
import com.estates.project.services.SellerService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSellerController {
    Seller newSeller = new Seller("Brian", "McCloudy", "Box", "Beach", "123456789" );

    public static MvcResult postComp; //Used to compare the returned result of the remove test with created seller.

    public static int objectId;

    @Autowired
    private SellerController sellerController;
    @Autowired
    private SellerService sellerService;

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Test  // Sanity test - checks that controller and service loads
    @Order(1)
    void contextLoads() throws Exception {
        assertThat(sellerController).isNotNull();
        assertThat(sellerService).isNotNull();
    }

    @Test
    @Order(2)
    public void testGetSellers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/seller"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @Order(3)
    public void testPostSeller() throws Exception {

        String reqBody = mapper.writeValueAsString(newSeller);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/seller")
                        .content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        postComp = mvcResult;

        String response = mvcResult.getResponse().getContentAsString();
        JsonNode jsonResponse = mapper.readTree(response);
        objectId = jsonResponse.get("id").asInt();
        System.out.println(objectId);


        Seller compareSeller = new Seller(objectId, "Brian", "McCloudy", "Box", "Beach", "123456789");
        String compareJSON = mapper.writeValueAsString(compareSeller);


        assertEquals(compareJSON, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @Order(4)
    public void testGetSellerById() throws Exception{

       mvc.perform(MockMvcRequestBuilders.get("/seller/"+objectId))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(objectId)))
                .andDo(print());
    }

    @Test
    @Order(5)
    public void testPatchSeller() throws Exception {

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("firstName", "Josie");

        mvc.perform(MockMvcRequestBuilders.patch("/seller/"+objectId).contentType(MediaType.APPLICATION_JSON).params(parameters))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName",Matchers.is("Josie")));
    }

    @Test
    @Order(6)
    public void testRemoveSeller() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/seller/"+objectId)
                        .content(postComp.getResponse().getContentAsString()).contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(objectId)))
                        .andReturn();

//        assertNotSame(postComp.getResponse().getContentAsString(), mvcResult.getResponse().getContentAsString());
    }

    //Below just to show that the new seller is removed.
    @Test
    @Order(7)
    public void testGetSellersFin() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/seller"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
}
