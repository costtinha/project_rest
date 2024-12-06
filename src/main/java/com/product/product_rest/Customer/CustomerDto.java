package com.product.product_rest.Customer;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CustomerDto(@NotNull int salesRepEmployeeNum, String lastName,
                          @NotNull String firstName, String phone,
                          String address1,
                          String address2,
                          String city, String state,
                          int postalCode,
                          String country,
                          BigDecimal creditLimit) {
}
