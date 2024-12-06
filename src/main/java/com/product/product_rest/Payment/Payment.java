package com.product.product_rest.Payment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.product.product_rest.Customer.Customer;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Payment {
    @Id
    private String CheckNum;

    @ManyToOne
    @JsonBackReference
    @JoinColumn( name = "id")
    private Customer CustomerId;

    private LocalDateTime PaymentDate;

    @Column(
            precision = 19,
            scale = 0
    )
    private BigDecimal Amount;

    public Payment(String CheckNum,Customer customerId, LocalDateTime paymentDate, BigDecimal amount) {
        this.CheckNum = CheckNum;
        CustomerId = customerId;
        PaymentDate = paymentDate;
        Amount = amount;
    }

    public Payment() {
    }

    public String getCheckNum() {
        return CheckNum;
    }

    public void setCheckNum(String checkNum) {
        CheckNum = checkNum;
    }

    public Customer getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Customer customerId) {
        CustomerId = customerId;
    }

    public LocalDateTime getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        PaymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }
}
