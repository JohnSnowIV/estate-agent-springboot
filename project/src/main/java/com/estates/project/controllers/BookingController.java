package com.estates.project.controllers;

import com.estates.project.entities.Booking;
import com.estates.project.entities.Seller;
import com.estates.project.exceptions.BookingNotFoundException;
import com.estates.project.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {
        @Autowired
        private BookingService service;
        public BookingController(BookingService service){
                this.service = service;
        }



        @PostMapping("/create")
        public Booking createBooking(@RequestBody Booking newBooking){return this.service.createBooking(newBooking);}

        @DeleteMapping("/remove/{id}")
        public Booking deleteBooking(@PathVariable Integer id) throws BookingNotFoundException {
                return this.service.deleteBooking(id);
        }

        @GetMapping("/{id}")
        public Booking getById(@PathVariable Integer id) throws BookingNotFoundException {
                return this.service.getById(id);
        }

        @PatchMapping("/update/{id}")
        public Booking updateBooking(@PathVariable Integer id,
                                     @RequestParam(required = false) Integer propertyId,
                                     @RequestParam(required = false) Integer buyerId,
                                     @RequestParam(required = false) String dateTime) throws BookingNotFoundException {
                return this.service.updateBooking(id,propertyId,buyerId,dateTime);
        }

        @GetMapping("/getAll")
        public List<Booking> getAll(){
                return this.service.getAll();
        }



}