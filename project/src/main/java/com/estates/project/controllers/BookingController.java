package com.estates.project.controllers;

import com.estates.project.entities.Booking;
import com.estates.project.entities.Seller;
import com.estates.project.services.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class BookingController {
        private BookingService service;
        public BookingController(BookingService service){
            this.service = service;
        }



        @PostMapping("/booking")
        public Booking createBooking(@RequestBody Booking newBooking){return this.service.createBooking(newBooking);}

        @DeleteMapping("/booking/{id}")
        public Booking deleteBooking(@PathVariable Integer id){
                return this.service.deleteBooking(id);
        }

        @GetMapping("/booking/{id}")
        public Booking getById(@PathVariable Integer id){
                return this.service.getById(id);
        }

        @PatchMapping("/booking/{id}")
        public Booking updateBooking(@PathVariable Integer id,
                                     @RequestParam(required = false) Integer propertyId,
                                     @RequestParam(required = false) Integer buyerId,
                                     @RequestParam(required = false) String dateTime){
                return this.service.updateBooking(id,propertyId,buyerId,dateTime);
        }

        @GetMapping("/booking")
        public List<Booking> getAll(){
                return this.service.getAll();
        }



}
