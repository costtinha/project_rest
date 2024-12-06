package com.product.product_rest.Order_Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<Order_Product, OrderProductKey> {
}
