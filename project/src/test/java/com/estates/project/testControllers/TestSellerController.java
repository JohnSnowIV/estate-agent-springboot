package com.estates.project.testControllers;

import com.estates.project.controllers.SellerController;

import com.estates.project.services.SellerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestSellerController {

    @Autowired
    private SellerController sellerController;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private MockMvc mockMvc;

    // Sanity test - checks that controller and service loads
    @Test
    void contextLoads() throws Exception {
        assertThat(sellerController).isNotNull();
        assertThat(sellerService).isNotNull();
    }


}
