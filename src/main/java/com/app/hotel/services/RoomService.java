package com.app.hotel.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hotel.models.Hotel;
import com.app.hotel.models.Room;
import com.app.hotel.repository.RoomRepository;
import com.app.hotel.repository.HotelRepository;

/**
 * Service class for managing room operations.
 */
@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    /**
     * Retrieves all rooms from the database.
     * 
     * @return A list of all available rooms.
     */
    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    /**
     * Retrieves a specific room by its ID.
     * 
     * @param id The ID of the room.
     * @return The found room entity.
     * @throws RuntimeException if the room is not found.
     */
    public Room findRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));
    }

    /**
     * Updates an existing room's details.
     * 
     * @param id          The ID of the room to update.
     * @param updatedRoom The updated room data.
     * @return The updated room entity.
     * @throws RuntimeException if the room or associated hotel is not found.
     */
    public Room updateRoom(Long id, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));

        existingRoom.setType(updatedRoom.getType());
        existingRoom.setPricePerNight(updatedRoom.getPricePerNight());
        existingRoom.setCapacity(updatedRoom.getCapacity());
        existingRoom.setBedCount(updatedRoom.getBedCount());
        existingRoom.setFloor(updatedRoom.getFloor());
        existingRoom.setDescription(updatedRoom.getDescription());

        // Updating the associated hotel if provided
        if (updatedRoom.getHotel() != null && updatedRoom.getHotel().getId() != null) {
            Hotel hotel = hotelRepository.findById(updatedRoom.getHotel().getId())
                    .orElseThrow(
                            () -> new RuntimeException("Hotel not found with id: " + updatedRoom.getHotel().getId()));
            existingRoom.setHotel(hotel);
        }

        return roomRepository.save(existingRoom);
    }

    /**
     * Adds a new room to the database.
     * 
     * @param room The room entity to be added.
     * @return The saved room entity.
     * @throws RuntimeException if the associated hotel is not found.
     */
    public Room postRoom(Room room) {
        Hotel hotel = hotelRepository.findById(room.getHotel().getId())
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + room.getHotel().getId()));

        room.setHotel(hotel);
        return roomRepository.save(room);
    }

    /**
     * Deletes a room by its ID.
     * 
     * @param id The ID of the room to delete.
     * @throws RuntimeException if the room is not found.
     */
    public void deleteRoom(Long id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
        } else {
            throw new RuntimeException("Room not found with id: " + id);
        }
    }
}
