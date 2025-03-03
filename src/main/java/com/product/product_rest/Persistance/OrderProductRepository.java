package com.product.product_rest.Persistance;

import com.product.product_rest.Order_Product.OrderProductKey;
import com.product.product_rest.Order_Product.Order_Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<Order_Product, OrderProductKey> {
}
