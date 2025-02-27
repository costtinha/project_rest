package com.product.product_rest.Order;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record OrderDto(@NotNull int customerId,
                       LocalDateTime orderDate,
                       LocalDateTime requiredDate,
                       LocalDateTime shippedDate,
                       @NotNull int status, String coments,
                       int shipId, int storeId) {
}
