package com.product.product_rest.Store;

import jakarta.validation.constraints.NotNull;

public record StoreDto(@NotNull String storeName) {
}
