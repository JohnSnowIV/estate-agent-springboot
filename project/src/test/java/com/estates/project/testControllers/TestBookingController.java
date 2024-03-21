package com.estates.project.testControllers;

import com.estates.project.entities.Booking;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfiguration
public class TestBookingController {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void TestCreate() throws Exception{
        Booking newBooking = new Booking(1,3,"2024-03-10 20:44");
        String newBookingAsJson = this.mapper.writeValueAsString(newBooking);
        RequestBuilder mockRequest = MockMvcRequestBuilders.post("/create").contentType(MediaType.APPLICATION_JSON).content(newBookingAsJson);

    }


}
