package com.product.product_rest.Persistance;

import com.product.product_rest.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findProductByVendor(String vendor);
}
