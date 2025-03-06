package com.app.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.app.hotel.models.Payment;
import com.app.hotel.services.PaymentService;

import java.util.List;

/**
 * REST Controller for handling payment-related operations.
 */
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * Retrieves all payments.
     * 
     * @return A list of all registered payments.
     */
    @GetMapping
    public List<Payment> getAllPaymentsApi() {
        return paymentService.findAllPayments();
    }

    /**   
     * * Retrieves all payments.  
     * 
     * @return A list of all registered payments.
     */
    @GetMapping("/searchPayments")
    public List<Payment> getAllPayments() {
        return paymentService.findAllPayments();
    }

    /**
     * Retrieves a payment by its ID.
     * 
     * @param id The ID of the payment.
     * @return The payment entity.
     * @throws RuntimeException if the payment is not found.
     */
    @GetMapping("/findPaymentById/{id}")
    public Payment findPaymentById(@PathVariable Long id) {
        return paymentService.findPaymentById(id);
    }

    /**
     * Creates a new payment.
     * 
     * @param payment The payment entity to be created.
     * @return The saved payment entity.
     */
    @PostMapping("/postPayment")
    public Payment postPayment(@RequestBody Payment payment) {
        return paymentService.postPayment(payment);
    }

    /**
     * Deletes a payment by ID.
     * 
     * @param id The ID of the payment to delete.
     * @throws RuntimeException if the payment is linked to a booking.
     */
    @DeleteMapping("/deletePayment/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
    }

    /**
     * Updates an existing payment's information.
     * 
     * @param id             The ID of the payment to update.
     * @param updatedPayment The updated payment data.
     * @return The updated payment entity.
     * @throws RuntimeException if the payment is not found.
     */
    @PutMapping("/putPayment/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
        return paymentService.updatePayment(id, updatedPayment);
    }
}
