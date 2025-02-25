package com.product.product_rest.Customer;

public record CustomerResponseDto(int salesRepEmployeeNum,
                                  String lastName,
                                  String firstName,
                                  String phone,
                                  String state,
                                  String country) {
}
