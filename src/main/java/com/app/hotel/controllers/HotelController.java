package com.app.hotel.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.app.hotel.services.HotelService;
import com.app.hotel.models.Hotel;

/**
 * REST Controller for handling hotel-related operations.
 */
@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    /**
     * Retrieves all hotels.
     * 
     * @return A list of all registered hotels.
     */
    @GetMapping
    public List<Hotel> getAllHotelsApi() {
        return hotelService.findAllHotels();
    }

    /**
     * Retrieves all hotels.
     * 
     * @return A list of all registered hotels.
     */
    @GetMapping("/searchHotels")
    public List<Hotel> getAllHotels() {
        return hotelService.findAllHotels();
    }

    /**
     * Retrieves a hotel by its ID.
     * 
     * @param id The ID of the hotel.
     * @return The hotel entity.
     * @throws RuntimeException if the hotel is not found.
     */
    @GetMapping("/findHotelById/{id}")
    public Hotel findHotelById(@PathVariable Long id) {
        return hotelService.findHotelById(id);
    }

    /**
     * Creates a new hotel.
     * 
     * @param hotel The hotel entity to be created.
     * @return The saved hotel entity.
     */
    @PostMapping("/postHotel")
    public Hotel postHotel(@RequestBody Hotel hotel) {
        return hotelService.postHotel(hotel);
    }

    /**
     * Deletes a hotel by ID.
     * 
     * @param id The ID of the hotel to delete.
     * @throws RuntimeException if the hotel is not found.
     */
    @DeleteMapping("/deleteHotel/{id}")
    public void deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
    }

    /**
     * Updates an existing hotel's information.
     * 
     * @param id           The ID of the hotel to update.
     * @param updatedHotel The updated hotel data.
     * @return The updated hotel entity.
     * @throws RuntimeException if the hotel is not found.
     */
    @PutMapping("/putHotel/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel updatedHotel) {
        return hotelService.updateHotel(id, updatedHotel);
    }
}
