package com.estates.project.testControllers;

import com.estates.project.controllers.SellerController;

import com.estates.project.services.SellerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class TestSellerController {

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
    @Transactional
    public void testGetSellers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/seller/getAll"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(7)));
    }


}
