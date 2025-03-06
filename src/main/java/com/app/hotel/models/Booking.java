package com.app.hotel.models;

import jakarta.persistence.*;

/**
 * Entity representing a booking in the hotel system.
 */
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the booking

    @Column(nullable = false, length = 30)
    private String checkInDate; // Date of the check-in

    @Column(nullable = false, length = 30)
    private String checkOutDate; // Date of the check-out

    @Column(nullable = false)
    private double totalPrice; // Total price of the booking

    @Column(nullable = false, length = 30)
    private String status; // Status of the booking

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer; // Customer associated with the booking

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room; // Room associated with the booking

    @OneToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment; // Payment associated with the booking

    /**
     * Default constructor.
     */
    public Booking() {
        super();
    }

    /**
     * Parameterized constructor to create a booking.
     * 
     * @param checkInDate  The check-in date of the booking.
     * @param checkOutDate The check-out date of the booking.
     * @param totalPrice   The total price of the booking.
     * @param status       The status of the booking.
     * @param customer     The customer associated with the booking.
     * @param room         The room associated with the booking.
     * @param payment      The payment information for the booking.
     */
    public Booking(String checkInDate, String checkOutDate, double totalPrice, String status, Customer customer,
            Room room, Payment payment) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.status = status;
        this.customer = customer;
        this.room = room;
        this.payment = payment;
    }

    // Getters and Setters

    /**
     * Gets the booking ID.
     * 
     * @return The booking ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the check-in date.
     * 
     * @return The check-in date.
     */
    public String getCheckInDate() {
        return checkInDate;
    }

    /**
     * Sets the check-in date.
     * 
     * @param checkInDate The new check-in date.
     */
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * Gets the check-out date.
     * 
     * @return The check-out date.
     */
    public String getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Sets the check-out date.
     * 
     * @param checkOutDate The new check-out date.
     */
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    /**
     * Gets the total price of the booking.
     * 
     * @return The total price.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the total price of the booking.
     * 
     * @param totalPrice The new total price.
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Gets the status of the booking.
     * 
     * @return The booking status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the booking.
     * 
     * @param status The new booking status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the customer associated with the booking.
     * 
     * @return the customer associated with the booking
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer associated with the booking.
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /*
     * Gets the room associated with the booking.
     * 
     * @return the room associated with the booking
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets the room associated with the booking.
     * 
     * @param room the room associated with the booking
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /*
     * Gets the payment associated with the booking.
     * 
     * @return the payment associated with the booking
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Sets the payment associated with the booking.
     * 
     * @param payment
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
