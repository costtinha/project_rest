package com.product.product_rest.Payment;

import com.product.product_rest.Customer.Customer;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentDto(String CheckNum,
                         @NotNull int customerId,
                         BigDecimal amount) {
}
