package com.product.product_rest.Payment;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentResponseDto(int customerId, LocalDateTime paymentDate,
                                 BigDecimal amount) {
}
