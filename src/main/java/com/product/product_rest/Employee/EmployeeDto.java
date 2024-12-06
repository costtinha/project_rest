package com.product.product_rest.Employee;

import jakarta.validation.constraints.NotNull;

public record EmployeeDto(@NotNull int OfficeCode,
                          int reportsTo,
                          @NotNull String lastName,
                          @NotNull String firstName,
                          String extension,
                          String email,
                          String jobTitle) {
}
