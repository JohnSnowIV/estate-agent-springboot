package com.estates.project.services;

import com.estates.project.entities.Booking;
import com.estates.project.entities.Seller;
import com.estates.project.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BookingService {
    private BookingRepository repo;
    public BookingService(BookingRepository repo){
        this.repo=repo;
    }


    public Booking createBooking(Booking newBooking){return this.repo.save(newBooking);}

    public Booking deleteBooking(Integer id){
        Booking removed = this.getById(id);
        this.repo.deleteById(id);
        return removed;}


    public Booking getById(Integer id){
        return this.repo.findById(id).get();}

    public Booking updateBooking(Integer id,
                                 @RequestParam(required = false) Integer propertyId,
                                 @RequestParam(required = false) Integer buyerId,
                                 @RequestParam(required = false) String dateTime){
        Booking toUpdate = this.getById(id);

        if (propertyId != null) toUpdate.setPropertyId(propertyId);

        if (buyerId != null) toUpdate.setBuyerId(buyerId);

        if (dateTime != null) toUpdate.setDateTime(dateTime);

        return this.repo.save((toUpdate));

    }
    public List<Booking> getAll(){
        return this.repo.findAll();
    }





}
