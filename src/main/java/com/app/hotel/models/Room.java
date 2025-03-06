package com.app.hotel.models;

import java.util.List;

import jakarta.persistence.*;

/**
 * Entity class representing a room in a hotel.
 */
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the room

    @Column(nullable = false, length = 100)
    private String type; // Type of room (e.g., single, double, suite)

    @Column(name = "price_per_night", nullable = false)
    private double pricePerNight; // Price per night for the room

    @Column(nullable = false)
    private int capacity; // Maximum number of occupants

    @Column(nullable = false)
    private int bedCount; // Number of beds in the room

    @Column(nullable = false)
    private int floor; // Floor where the room is located

    @Column(nullable = false, length = 100)
    private String description; // Description of the room

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings; // List of bookings associated with the room

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel; // Hotel to which the room belongs

    /**
     * Default constructor.
     */
    public Room() {
        super();
    }

    /**
     * Parameterized constructor to initialize a room with details.
     * 
     * @param type          Type of room
     * @param pricePerNight Price per night
     * @param capacity      Maximum capacity
     * @param bedCount      Number of beds
     * @param floor         Floor number
     * @param description   Room description
     * @param hotel         Associated hotel
     */
    public Room(String type, double pricePerNight, int capacity, int bedCount, int floor, String description,
            Hotel hotel) {
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.bedCount = bedCount;
        this.floor = floor;
        this.description = description;
        this.hotel = hotel;
    }

    /**
     * Gets the room ID.
     * 
     * @return the room ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the room type.
     * 
     * @return the room type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the room type.
     * 
     * @param type the room type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the price per night.
     * 
     * @return the price per night
     */
    public double getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Sets the price per night.
     * 
     * @param pricePerNight the price per night to set
     */
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    /**
     * Gets the room capacity.
     * 
     * @return the room capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the room capacity.
     * 
     * @param capacity the room capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets the number of beds.
     * 
     * @return the number of beds
     */
    public int getBedCount() {
        return bedCount;
    }

    /**
     * Sets the number of beds.
     * 
     * @param bedCount the number of beds to set
     */
    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    /**
     * Gets the floor number.
     * 
     * @return the floor number
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Sets the floor number.
     * 
     * @param floor the floor number to set
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * Gets the room description.
     * 
     * @return the room description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the room description.
     * 
     * @param description the room description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the associated hotel.
     * 
     * @return the associated hotel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Sets the associated hotel.
     * 
     * @param hotel the associated hotel to set
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
