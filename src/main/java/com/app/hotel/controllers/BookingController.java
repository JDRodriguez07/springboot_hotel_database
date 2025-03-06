package com.app.hotel.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.app.hotel.models.Booking;
import com.app.hotel.services.BookingService;

/**
 * REST controller for managing hotel bookings.
 */
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    /**
     * Retrieves a list of all bookings.
     * 
     * @return List of bookings.
     */
    @GetMapping
    public List<Booking> getAllBookingsApi() {
        return bookingService.findAllBookings();
    }

    /**
     * Retrieves a list of all bookings.
     * 
     * @return List of bookings.
     */
    @GetMapping("/searchBookings")
    public List<Booking> getAllBookings() {
        return bookingService.findAllBookings();
    }

    /**
     * Retrieves a booking by its ID.
     * 
     * @param id The ID of the booking.
     * @return The booking with the specified ID.
     */
    @GetMapping("/findBookingById/{id}")
    public Booking findBookingById(@PathVariable Long id) {
        return bookingService.findBookingById(id);
    }

    /**
     * Creates a new booking.
     * 
     * @param booking The booking object to be created.
     * @return The created booking.
     */
    @PostMapping("/postBooking")
    public Booking postBooking(@RequestBody Booking booking) {
        return bookingService.postBooking(booking);
    }

    /**
     * Deletes a booking by its ID.
     * 
     * @param id The ID of the booking to be deleted.
     */
    @DeleteMapping("/deleteBooking/{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    /**
     * Updates an existing booking.
     * 
     * @param id             The ID of the booking to update.
     * @param updatedBooking The updated booking details.
     * @return The updated booking.
     */
    @PutMapping("/putBooking/{id}")
    public Booking updateBooking(@PathVariable Long id, @RequestBody Booking updatedBooking) {
        return bookingService.updateBooking(id, updatedBooking);
    }
}
