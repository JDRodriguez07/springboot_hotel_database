package com.app.hotel.models;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity class representing a customer in the hotel booking system.
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the customer

    @Column(nullable = false, length = 100)
    private String name; // Customer's name

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName; // Customer's last name

    @Column(nullable = false, length = 20)
    private String gender; // Customer's gender

    @Column(nullable = false)
    private int age; // Customer's age

    @Column(nullable = false, length = 100, unique = true)
    private String email; // Customer's email address

    @Column(nullable = false, length = 15, unique = true)
    private String phoneNumber; // Customer's phone number

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Booking> bookings; // List of bookings associated with the customer

    /**
     * Default constructor.
     */
    public Customer() {
        super();
    }

    /**
     * Parameterized constructor to initialize a customer with basic details.
     * 
     * @param name        Customer's first name
     * @param lastName    Customer's last name
     * @param gender      Customer's gender
     * @param age         Customer's age
     * @param email       Customer's email address
     * @param phoneNumber Customer's phone number
     */
    public Customer(String name, String lastName, String gender, int age, String email, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the customer ID.
     * 
     * @return the customer ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the customer's first name.
     * 
     * @return the customer's first name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer's first name.
     * 
     * @param name the first name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the customer's last name.
     * 
     * @return the customer's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the customer's last name.
     * 
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the customer's gender.
     * 
     * @return the customer's gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the customer's gender.
     * 
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the customer's age.
     * 
     * @return the customer's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the customer's age.
     * 
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the customer's email address.
     * 
     * @return the customer's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the customer's email address.
     * 
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the customer's phone number.
     * 
     * @return the customer's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the customer's phone number.
     * 
     * @param phoneNumber the phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the list of bookings associated with the customer.
     * 
     * @return the list of bookings
     */
    public List<Booking> getBookings() {
        return bookings;
    }

    /**
     * Sets the list of bookings associated with the customer.
     * 
     * @param bookings the list of bookings to set
     */
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
