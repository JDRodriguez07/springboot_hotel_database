package com.app.hotel.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.hotel.models.Customer;
import com.app.hotel.repository.CustomerRepository;

/**
 * Service class for managing Customer entities.
 * Provides methods for creating, updating, deleting, and retrieving customers.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Saves a new customer.
     * 
     * @param customer the customer to save
     * @return the saved customer
     */
    public Customer postCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Updates an existing customer.
     * 
     * @param id              the ID of the customer to update
     * @param updatedCustomer the updated customer data
     * @return the updated customer
     */
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setLastName(updatedCustomer.getLastName());
        existingCustomer.setGender(updatedCustomer.getGender());
        existingCustomer.setAge(updatedCustomer.getAge());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());

        return customerRepository.save(existingCustomer);
    }

    /**
     * Deletes a customer by ID.
     * 
     * @param id the ID of the customer to delete
     */
    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    /**
     * Finds a customer by ID.
     * 
     * @param id the ID of the customer
     * @return the found customer
     */
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    /**
     * Finds a customer by name.
     * 
     * @param name the name of the customer
     * @return the found customer
     */
    public Customer findCustomerByName(String name) {
        return customerRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Customer not found with name: " + name));
    }

    /**
     * Retrieves all customers.
     * 
     * @return a list of all customers
     */
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
