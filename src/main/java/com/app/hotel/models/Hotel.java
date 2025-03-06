package com.app.hotel.models;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity class representing a hotel in the booking system.
 */
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the hotel

    @Column(nullable = false, length = 100)
    private String name; // Hotel's name

    @Column(nullable = false, length = 255)
    private String address; // Hotel's address

    @Column(nullable = false, length = 20)
    private String phoneNumber; // Hotel's phone number

    @Column(nullable = false, length = 100)
    private String email; // Hotel's email address

    @Column(nullable = false, length = 100)
    private String description; // Hotel's description

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Room> rooms; // List of rooms associated with the hotel

    /**
     * Default constructor.
     */
    public Hotel() {
        super();
    }

    /**
     * Parameterized constructor to initialize a hotel with basic details.
     * 
     * @param name        Hotel's name
     * @param address     Hotel's address
     * @param phoneNumber Hotel's phone number
     * @param email       Hotel's email address
     * @param description Hotel's description
     */
    public Hotel(String name, String address, String phoneNumber, String email, String description) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
    }

    /**
     * Gets the hotel ID.
     * 
     * @return the hotel ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the hotel's name.
     * 
     * @return the hotel's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the hotel's name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the hotel's address.
     * 
     * @return the hotel's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the hotel's address.
     * 
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the hotel's phone number.
     * 
     * @return the hotel's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the hotel's phone number.
     * 
     * @param phoneNumber the phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the hotel's email address.
     * 
     * @return the hotel's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the hotel's email address.
     * 
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the hotel's description.
     * 
     * @return the hotel's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the hotel's description.
     * 
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the list of rooms associated with the hotel.
     * 
     * @return the list of rooms
     */
    public List<Room> getRooms() {
        return rooms;
    }

    /**
     * Sets the list of rooms associated with the hotel.
     * 
     * @param rooms the list of rooms to set
     */
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
