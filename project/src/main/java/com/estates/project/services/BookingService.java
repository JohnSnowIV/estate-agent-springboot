package com.estates.project.services;

import com.estates.project.entities.Booking;
import com.estates.project.entities.Seller;
import com.estates.project.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookingService {
    private BookingRepository repo;
    public BookingService(BookingRepository repo){
        this.repo=repo;
    }


    public Booking createBooking(Booking booking){return this.repo.save(booking);}





}
