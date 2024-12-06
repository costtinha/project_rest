package com.product.product_rest.Product;

import com.product.product_rest.ProductLine.ProductLine;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductDto(int productLine_id, @NotNull String name,
                         String vendor,
                         String pdtDescription,
                         int qntyInStock,
                         BigDecimal buyPrice,
                         String MSRP) {
}
