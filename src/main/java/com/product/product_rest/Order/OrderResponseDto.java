package com.product.product_rest.Order;

import java.time.LocalDateTime;

public record OrderResponseDto(int customerId, LocalDateTime orderDate,
                               LocalDateTime requiredDate) {
}
