package com.product.product_rest.Shippers;

import jakarta.validation.constraints.NotNull;

public record ShippersDto(@NotNull String companyName, String phoneNumber) {
}
