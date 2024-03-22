package com.estates.project.testControllers;

import com.estates.project.entities.Buyer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TestBuyerController {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreateBuyer() throws Exception {

        Buyer newBuyer = new Buyer(
                "Bob",
                "Beans",
                "123 Oak Street",
                "QW1 2OP",
                "1234567"
        );

        String newBuyerAsJson = this.mapper.writeValueAsString(newBuyer);
        RequestBuilder mockRequest = MockMvcRequestBuilders.post("/buyer/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newBuyerAsJson);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        Buyer createdBuyer = new Buyer(
                4,
                "Bob",
                "Beans",
                "123 Oak Street",
                "QW1 2OP",
                "1234567"
        );

        String createdBuyerAsJson = this.mapper.writeValueAsString(createdBuyer);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdBuyerAsJson);

        this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);

    }
}
