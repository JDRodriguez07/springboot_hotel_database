package com.app.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.hotel.models.Hotel;
import com.app.hotel.repository.HotelRepository;
import java.util.List;

/**
 * Service class for managing hotel operations.
 */
@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    /**
     * Retrieves all hotels from the database.
     * 
     * @return a list of all hotels
     */
    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    /**
     * Saves a new hotel to the database.
     * 
     * @param hotel the hotel entity to be saved
     * @return the saved hotel entity
     */
    public Hotel postHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    /**
     * Deletes a hotel by its ID.
     * 
     * @param id the ID of the hotel to be deleted
     * @throws RuntimeException if the hotel is not found
     */
    public void deleteHotel(Long id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
        } else {
            throw new RuntimeException("Hotel not found with id: " + id);
        }
    }

    /**
     * Updates an existing hotel's details.
     * 
     * @param id           the ID of the hotel to be updated
     * @param updatedHotel the hotel entity with updated details
     * @return the updated hotel entity
     * @throws RuntimeException if the hotel is not found
     */
    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));

        existingHotel.setName(updatedHotel.getName());
        existingHotel.setAddress(updatedHotel.getAddress());
        existingHotel.setPhoneNumber(updatedHotel.getPhoneNumber());
        existingHotel.setEmail(updatedHotel.getEmail());
        existingHotel.setDescription(updatedHotel.getDescription());

        return hotelRepository.save(existingHotel);
    }

    /**
     * Finds a hotel by its ID.
     * 
     * @param id the ID of the hotel
     * @return the found hotel entity
     * @throws RuntimeException if the hotel is not found
     */
    public Hotel findHotelById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));
    }

    /**
     * Finds a hotel by its name.
     * 
     * @param name the name of the hotel
     * @return the found hotel entity
     * @throws RuntimeException if the hotel is not found
     */
    public Hotel findHotelByName(String name) {
        return hotelRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Hotel not found with name: " + name));
    }
}
