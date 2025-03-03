package com.product.product_rest.ProductLine;

import jakarta.validation.constraints.NotNull;

public record ProductLineDto(@NotNull String descInText,
                             String descInHTML,
                             String image) {
}
