package com.product.product_rest.Order_Product;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OrderProductDto(
                              @NotNull int orderId,
                              @NotNull int productId,
                              int qty,
                              BigDecimal priceEach) {
}
