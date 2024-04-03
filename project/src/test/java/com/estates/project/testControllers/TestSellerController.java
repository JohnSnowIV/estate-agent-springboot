package com.estates.project.testControllers;

import com.estates.project.controllers.SellerController;

import com.estates.project.entities.Seller;
import com.estates.project.services.SellerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.h2.api.H2Type;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
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

    //Initialising global newSeller
    Seller newSeller = new Seller("Brian", "McCloudy", "Box", "Beach", "123456789" );

    //Storing the postSeller as a variable to compare
    public static MvcResult postComp; //Used to compare the returned result of the remove test with created seller.

    public static int idOut2;

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

//        Seller compareSeller = new Seller(8, "Brian", "McCloudy", "Box", "Beach", "123456789");

        String reqBody = mapper.writeValueAsString(newSeller);
//        String compareJSON = mapper.writeValueAsString(compareSeller);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/seller")
                        .content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(idOut2)))
                .andReturn();

        postComp = mvcResult;

        String idOut = mvcResult.getResponse().getContentAsString();
        idOut = String.copyValueOf(idOut.toCharArray(), 6, 2);
        idOut2 = Integer.parseInt(idOut);

        System.out.println(idOut2);
        System.out.println(mvcResult.getResponse().getContentAsString());

//        assertEquals(compareJSON, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @Order(4)
    public void testGetSellerById() throws Exception{
//        idOut2 = 14;

        MvcResult getIdresult = mvc.perform(MockMvcRequestBuilders.get("/seller/"+idOut2))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

//        System.out.println(getIdresult.getFlashMap().get(id));
    }

    @Test
    @Order(5)
    public void testPatchSeller() throws Exception {

//        idOut2 = 14;

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("firstName", "Josie");

        mvc.perform(MockMvcRequestBuilders.patch("/seller/"+idOut2).contentType(MediaType.APPLICATION_JSON).params(parameters))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName",Matchers.is("Josie")));
    }

    @Test
    @Order(6)
    public void testRemoveSeller() throws Exception {
//        Seller delSeller1 = new Seller(14,"Josie", "McCloudy", "Box", "Beach", "123456789" );
//        Seller delSeller2 = new Seller(9,"Brian", "McCloudy", "Box", "Beach", "123456789" );

//        idOut2 = 14;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/seller/"+idOut2)
//                        .content(String.valueOf(delSeller1)).contentType(MediaType.APPLICATION_JSON))
                        .content(postComp.getResponse().getContentAsString()).contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(print())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(idOut2)))
                        .andReturn();

//        assertEquals(postComp.getResponse().getContentAsString(), mvcResult.getResponse().getContentAsString());
//        assertNotSame(postComp.getResponse().getContentAsString(), mvcResult.getResponse().getContentAsString());
    }
}
