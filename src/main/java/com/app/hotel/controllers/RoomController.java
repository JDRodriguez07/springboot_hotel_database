package com.app.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.app.hotel.models.Room;
import com.app.hotel.services.RoomService;

/**
 * REST Controller for handling room-related operations.
 */
@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * Retrieves all rooms.
     * 
     * @return A list of all registered rooms.
     */
    @GetMapping
    public List<Room> getAllRoomsApi() {
        return roomService.findAllRooms();
    }

    /** 
     * * Retrieves all rooms.    
     * 
     * @return A list of all registered rooms.
     */
    @GetMapping("/searchRooms")
    public List<Room> getAllRooms() {
        return roomService.findAllRooms();
    }

    /**
     * Retrieves a room by its ID.
     * 
     * @param id The ID of the room.
     * @return The room entity.
     * @throws RuntimeException if the room is not found.
     */
    @GetMapping("/findRoomById/{id}")
    public Room findRoomById(@PathVariable Long id) {
        return roomService.findRoomById(id);
    }

    /**
     * Creates a new room.
     * 
     * @param room The room entity to be created.
     * @return The saved room entity.
     * @throws RuntimeException if the associated hotel does not exist.
     */
    @PostMapping("/postRoom")
    public Room postRoom(@RequestBody Room room) {
        return roomService.postRoom(room);
    }

    /**
     * Deletes a room by ID.
     * 
     * @param id The ID of the room to delete.
     * @throws RuntimeException if the room is not found.
     */
    @DeleteMapping("/deleteRoom/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }

    /**
     * Updates an existing room's information.
     * 
     * @param id          The ID of the room to update.
     * @param updatedRoom The updated room data.
     * @return The updated room entity.
     * @throws RuntimeException if the room or associated hotel is not found.
     */
    @PutMapping("/putRoom/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room updatedRoom) {
        return roomService.updateRoom(id, updatedRoom);
    }

}
