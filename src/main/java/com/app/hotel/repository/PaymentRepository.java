package com.app.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.hotel.models.Payment;

/**
 * Repository interface for managing Payment entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
