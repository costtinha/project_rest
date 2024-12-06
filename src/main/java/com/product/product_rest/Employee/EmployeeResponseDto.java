package com.product.product_rest.Employee;

public record EmployeeResponseDto(int OfficeCode,
                                  String lastName,
                                  String firstName,
                                  String email,
                                  String jobTitle) {
}
