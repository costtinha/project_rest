package com.product.product_rest.Customer;

public record PaymentResponseDto(int salesRepEmployeeNum,
                                 String lastName,
                                 String firstName,
                                 String phone,
                                 String state,
                                 String country) {
}
