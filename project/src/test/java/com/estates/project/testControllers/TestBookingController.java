package com.estates.project.testControllers;

import com.estates.project.entities.Booking;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.print.DocFlavor;

@SpringBootTest
@AutoConfigureMockMvc
public class TestBookingController {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void TestCreate() throws Exception{
        Booking newBooking = new Booking(1,3,"2024-03-10 20:44");
        String newBookingAsJson = this.mapper.writeValueAsString(newBooking);
        RequestBuilder mockRequest = MockMvcRequestBuilders.post("/booking/create").contentType(MediaType.APPLICATION_JSON).content(newBookingAsJson);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        Booking createdBooking = new Booking(3,1,3,"2024-03-10 20:44");
        String createdBookingAsJson = this.mapper.writeValueAsString(createdBooking);

        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdBookingAsJson);
        this.mvc.perform(mockRequest).andExpect( checkStatus).andExpect(checkBody);
    }

//    @Test
//    public void TestDelete() throws Exception{
//        Booking newBooking = new Booking(1,3,"2024-03-10 20:44");
//        String newBookingAsJson = this.mapper.writeValueAsString(newBooking);
//        RequestBuilder mockRequest = MockMvcRequestBuilders.post("/booking/create").contentType(MediaType.APPLICATION_JSON).content(newBookingAsJson);
//
//        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
//        Booking createdBooking = new Booking(3,1,3,"2024-03-10 20:44");
//        String createdBookingAsJson = this.mapper.writeValueAsString(createdBooking);
//
//        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdBookingAsJson);
//        this.mvc.perform(mockRequest).andExpect( checkStatus).andExpect(checkBody);
//
//    }


}
