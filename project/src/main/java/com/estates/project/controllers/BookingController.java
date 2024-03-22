package com.estates.project.controllers;

import com.estates.project.entities.Booking;
import com.estates.project.entities.Seller;
import com.estates.project.services.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
        private BookingService service;
        public BookingController(BookingService service){
            this.service = service;
        }



        @PostMapping("/create")
        public Booking createBooking(@RequestBody Booking newBooking){return this.service.createBooking(newBooking);}

        @DeleteMapping("/remove/{id}")
        public Booking deleteBooking(@PathVariable Integer id){
                return this.service.deleteBooking(id);
        }

        @GetMapping("/getById/{id}")
        public Booking getById(@PathVariable Integer id){
                return this.service.getById(id);
        }




}
