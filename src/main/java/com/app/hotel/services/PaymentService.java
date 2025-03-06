package com.app.hotel.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.hotel.models.Payment;
import com.app.hotel.repository.BookingRepository;
import com.app.hotel.repository.PaymentRepository;

/**
 * Service class for managing payments in the hotel booking system.
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    /**
     * Creates a new payment record.
     * 
     * @param payment The payment details to be saved.
     * @return The saved Payment entity.
     */
    public Payment postPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    /**
     * Updates an existing payment.
     * 
     * @param id             The ID of the payment to update.
     * @param updatedPayment The updated payment details.
     * @return The updated Payment entity.
     * @throws RuntimeException if the payment ID is not found.
     */
    public Payment updatePayment(Long id, Payment updatedPayment) {
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));

        existingPayment.setMethod(updatedPayment.getMethod());
        existingPayment.setStatus(updatedPayment.getStatus());
        existingPayment.setAmount(updatedPayment.getAmount());

        return paymentRepository.save(existingPayment);
    }

    /**
     * Deletes a payment if it is not linked to any booking.
     * 
     * @param id The ID of the payment to delete.
     * @throws RuntimeException if the payment is linked to a booking or does not exist.
     */
    public void deletePayment(Long id) {
        boolean isPaymentLinked = bookingRepository.existsByPaymentId(id);

        if (isPaymentLinked) {
            throw new RuntimeException("Cannot delete Payment with id: " + id + " because it is linked to a Booking.");
        }

        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Payment not found with id: " + id);
        }

        paymentRepository.deleteById(id);
    }

    /**
     * Finds a payment by its ID.
     * 
     * @param id The ID of the payment.
     * @return The found Payment entity.
     * @throws RuntimeException if the payment ID is not found.
     */
    public Payment findPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    /**
     * Retrieves all payments from the database.
     * 
     * @return A list of all payments.
     */
    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }
}
