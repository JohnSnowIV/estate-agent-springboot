package com.estates.project.exceptions;

import com.estates.project.entities.Booking;

public class BookingNotFoundException extends Exception {
    public BookingNotFoundException(String message) {
        super(message);
    }
}
