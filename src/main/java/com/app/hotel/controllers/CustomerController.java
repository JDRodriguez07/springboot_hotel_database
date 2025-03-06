package com.app.hotel.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.app.hotel.models.Customer;
import com.app.hotel.services.CustomerService;

/**
 * REST Controller for handling customer-related operations.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Retrieves all customers.
     * 
     * @return A list of all registered customers.
     */
    @GetMapping
    public List<Customer> getAllCustomersApi() {
        return customerService.findAllCustomers();
    }

    /**
     * Retrieves all customers.
     * 
     * @return A list of all registered customers.
     */
    @GetMapping("/searchCustomers")
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    /**
     * Retrieves a customer by its ID.
     * 
     * @param id The ID of the customer.
     * @return The customer entity.
     * @throws RuntimeException if the customer is not found.
     */
    @GetMapping("/findCustomerById/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    /**
     * Creates a new customer.
     * 
     * @param customer The customer entity to be created.
     * @return The saved customer entity.
     */
    @PostMapping("/postCustomer")
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.postCustomer(customer);
    }

    /**
     * Deletes a customer by ID.
     * 
     * @param id The ID of the customer to delete.
     * @throws RuntimeException if the customer is not found.
     */
    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    /**
     * Updates an existing customer's information.
     * 
     * @param id              The ID of the customer to update.
     * @param updatedCustomer The updated customer data.
     * @return The updated customer entity.
     * @throws RuntimeException if the customer is not found.
     */
    @PutMapping("/putCustomer/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(id, updatedCustomer);
    }
}
