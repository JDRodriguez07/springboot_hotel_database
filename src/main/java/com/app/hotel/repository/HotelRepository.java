package com.app.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.app.hotel.models.Hotel;

/**
 * Repository interface for managing Hotel entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    /**
     * Finds a hotel by its name.
     * 
     * @param name the name of the hotel
     * @return an Optional containing the found hotel, or empty if not found
     */
    Optional<Hotel> findByName(String name);
}
