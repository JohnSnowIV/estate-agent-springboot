package com.estates.project.testControllers;

import com.estates.project.entities.Booking;
import com.estates.project.repository.BookingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
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
import org.springframework.transaction.annotation.Transactional;

import javax.print.DocFlavor;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestBookingController {

    Booking newBooking = new Booking(1,3,"2024-03-10 20:44");
    @Mock
    private BookingRepository bookRepo;
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    @Transactional
    void TestCreate() throws Exception{
       // Booking newBooking = new Booking(1,3,"2024-03-10 20:44");
        String newBookingAsJson = this.mapper.writeValueAsString(newBooking);
        RequestBuilder mockRequest = MockMvcRequestBuilders.post("/booking/create").contentType(MediaType.APPLICATION_JSON).content(newBookingAsJson);

        ResultMatcher checkStatus = status().isOk();
        Booking createdBooking = new Booking(3,1,3,"2024-03-10 20:44");
        String createdBookingAsJson = this.mapper.writeValueAsString(createdBooking);

        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdBookingAsJson);
        this.mvc.perform(mockRequest).andExpect( checkStatus).andExpect(checkBody);
    }

    @Test
    @Transactional
    public void TestDelete() throws Exception{
        RequestBuilder mockRequest = MockMvcRequestBuilders.post("/booking/remove/3").contentType(MediaType.APPLICATION_JSON);
       // this.mvc.perform(mockRequest).andExpect(status().isOk());
        Mockito.when(bookRepo.getById(newBooking.getId())).thenReturn(newBooking);

//        mvc.perform(MockMvcRequestBuilders
//                .delete("/remove/3")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());




    }
    }



