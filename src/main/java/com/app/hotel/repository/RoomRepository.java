package com.app.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.hotel.models.Room;

/**
 * Repository interface for managing Room entities.
 * Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
