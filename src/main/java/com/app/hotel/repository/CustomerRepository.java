package com.app.hotel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.hotel.models.Customer;

/**
 * Repository interface for managing Customer entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Finds a customer by their name.
     * 
     * @param name the name of the customer
     * @return an Optional containing the found customer, or empty if not found
     */
    Optional<Customer> findByName(String name);
}
