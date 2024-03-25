package com.estates.project.services;

import com.estates.project.entities.Booking;
import com.estates.project.entities.Seller;
import com.estates.project.exceptions.BookingNotFoundException;
import com.estates.project.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private BookingRepository repo;
    public BookingService(BookingRepository repo){
        this.repo=repo;
    }


    public Booking createBooking(Booking newBooking){return this.repo.save(newBooking);}

    public Booking deleteBooking(Integer id) throws BookingNotFoundException {
        Booking removed = this.getById(id);
        this.repo.deleteById(id);
        return removed;}


    public Booking getById(Integer id) throws BookingNotFoundException {
        Booking booking = this.repo.getById(id);
        System.out.println(booking.getId() );
        if(booking.getId() != null){
            return booking;
        }
        else{
//            try {
//                throw new BookingNotFoundException("Booking not found with id: " +id);
//            } catch (BookingNotFoundException e) {
//                throw new RuntimeException(e);
//            }
           throw new BookingNotFoundException("Booking not found with id: "+id);
        }
    }

    public Booking updateBooking(Integer id,
                                 @RequestParam(required = false) Integer propertyId,
                                 @RequestParam(required = false) Integer buyerId,
                                 @RequestParam(required = false) String dateTime) throws BookingNotFoundException {
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
