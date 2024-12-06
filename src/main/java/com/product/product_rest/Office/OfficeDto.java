package com.product.product_rest.Office;

import jakarta.validation.constraints.NotNull;

public record OfficeDto(@NotNull String city, @NotNull String phone,
                        @NotNull String address1,
                        String address2,
                        String state,
                        @NotNull String country,
                        int postalCode,
                        String territory) {
}
