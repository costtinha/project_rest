package com.product.product_rest.Order_Product;

import java.math.BigDecimal;

public record OrderProductResponseDto(int orderId,
                                      int productCode,
                                      int qty,
                                      BigDecimal priceEach) {
}
