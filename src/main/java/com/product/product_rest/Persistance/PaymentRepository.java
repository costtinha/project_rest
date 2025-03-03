package com.product.product_rest.Persistance;

import com.product.product_rest.Payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, String> {
    List<Payment> findPaymentByCustomerId(int customerId);
}
