package com.app.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.hotel.models.Booking;
import com.app.hotel.models.Customer;
import com.app.hotel.models.Payment;
import com.app.hotel.models.Room;
import com.app.hotel.repository.BookingRepository;
import com.app.hotel.repository.CustomerRepository;
import com.app.hotel.repository.PaymentRepository;
import com.app.hotel.repository.RoomRepository;

import java.util.List;

/**
 * Service class for managing bookings.
 */
@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * Creates a new booking.
     * 
     * @param booking The booking to be created.
     * @return The saved booking.
     */
    public Booking postBooking(Booking booking) {

        Customer customer = customerRepository.findById(booking.getCustomer().getId())
                .orElseThrow(
                        () -> new RuntimeException("Customer not found with id: " + booking.getCustomer().getId()));

        Room room = roomRepository.findById(booking.getRoom().getId())
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + booking.getRoom().getId()));

        Payment payment = paymentRepository.findById(booking.getPayment().getId())
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + booking.getPayment().getId()));

        booking.setCustomer(customer);
        booking.setRoom(room);
        booking.setPayment(payment);

        return bookingRepository.save(booking);
    }

    /**
     * Retrieves all bookings.
     * 
     * @return A list of all bookings.
     */
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    /**
     * Updates an existing booking.
     * 
     * @param id             The ID of the booking to be updated.
     * @param updatedBooking The updated booking details.
     * @return The updated booking.
     */
    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));

        existingBooking.setCheckInDate(updatedBooking.getCheckInDate());
        existingBooking.setCheckOutDate(updatedBooking.getCheckOutDate());
        existingBooking.setTotalPrice(updatedBooking.getTotalPrice());
        existingBooking.setStatus(updatedBooking.getStatus());

        return bookingRepository.save(existingBooking);
    }

    /**
     * Deletes a booking by its ID.
     * 
     * @param id The ID of the booking to be deleted.
     */
    public void deleteBooking(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
        } else {
            throw new RuntimeException("Booking not found with id: " + id);
        }
    }

    /**
     * Finds a booking by its ID.
     * 
     * @param id The ID of the booking.
     * @return The found booking.
     */
    public Booking findBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }
}
