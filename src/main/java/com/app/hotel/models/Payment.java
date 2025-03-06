package com.app.hotel.models;

import jakarta.persistence.*;

/**
 * Entity class representing a payment in the booking system.
 */
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the payment

    @Column(nullable = false, length = 100)
    private String method; // Payment method (e.g., credit card, PayPal)

    @Column(nullable = false, length = 50)
    private String status; // Payment status (e.g., completed, pending)

    @Column(nullable = false)
    private double amount; // Payment amount

    /**
     * Default constructor.
     */
    public Payment() {
        super();
    }

    /**
     * Parameterized constructor to initialize a payment with details.
     * 
     * @param method Payment method
     * @param status Payment status
     * @param amount Payment amount
     */
    public Payment(String method, String status, double amount) {
        this.method = method;
        this.status = status;
        this.amount = amount;
    }

    /**
     * Gets the payment ID.
     * 
     * @return the payment ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the payment method.
     * 
     * @return the payment method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the payment method.
     * 
     * @param method the payment method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Gets the payment status.
     * 
     * @return the payment status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the payment status.
     * 
     * @param status the payment status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the payment amount.
     * 
     * @return the payment amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the payment amount.
     * 
     * @param amount the payment amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
