package com.product.product_rest.Product;

import com.product.product_rest.ProductLine.ProductLine;

import java.math.BigDecimal;

public record ProductResponseDto(String name, int qntyInStock, BigDecimal buyPrice) {
}
