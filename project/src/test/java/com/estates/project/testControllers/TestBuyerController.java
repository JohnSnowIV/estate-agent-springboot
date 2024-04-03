package com.estates.project.testControllers;

import com.estates.project.controllers.BuyerController;
import com.estates.project.entities.Buyer;
import com.estates.project.services.BuyerService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestBuyerController {
    Buyer newBuyer = new Buyer(
            "Bob",
            "Beans",
            "123 Oak Street",
            "QW1 2OP",
            "1234567"
    );
    public static MvcResult postComp;
    public static  int objectId;
    @Autowired
    private BuyerController buyerController;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @Test
    @Order(1)
    void contextLoads() throws Exception {
        assertThat(buyerController).isNotNull();
        assertThat(buyerService).isNotNull();
    }
    @Test
    @Order(2)
    public void testGetBuyers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/buyer"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    @Order(3)
    public void testPostBuyer() throws Exception {

        String reqBody = mapper.writeValueAsString(newBuyer);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/buyer")
                        .content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();

        postComp = mvcResult;

        String response = mvcResult.getResponse().getContentAsString();
        JsonNode jsonResponse = mapper.readTree(response);
        objectId = jsonResponse.get("id").asInt();
        System.out.println(objectId);


        Buyer compareBuyer = new Buyer(
                objectId,
                "Bob",
                "Beans",
                "123 Oak Street",
                "QW1 2OP",
                "1234567"
        );
        String compareJSON = mapper.writeValueAsString(compareBuyer);


        assertEquals(compareJSON, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @Order(4)
    public void testGetBuyerById() throws Exception{

        mvc.perform(MockMvcRequestBuilders.get("/buyer/"+objectId))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(objectId)))
                .andDo(print());
    }

    @Test
    @Order(5)
    public void testPatchBuyer() throws Exception {

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("firstName", "Frank");

        mvc.perform(MockMvcRequestBuilders.patch("/buyer/"+objectId).contentType(MediaType.APPLICATION_JSON).params(parameters))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("Frank")));
    }

    @Test
    @Order(6)
    public void testRemoveBuyer() throws Exception {
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete("/buyer/"+objectId)
                        .content(postComp.getResponse().getContentAsString()).contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andDo(print())
//                        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(objectId)))
                        .andReturn();
    }

    //Below just to show that the new seller is removed.
    @Test
    @Order(7)
    public void testGetBuyersFin() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/buyer"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
}