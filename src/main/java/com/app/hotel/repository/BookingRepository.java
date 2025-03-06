package com.app.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.hotel.models.Booking;

/**
 * Repository interface for managing Booking entities.
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    /**
     * Checks if a booking exists by a given payment ID.
     * 
     * @param paymentId The ID of the payment.
     * @return true if a booking exists with the given payment ID, false otherwise.
     */
    boolean existsByPaymentId(Long paymentId);
}
