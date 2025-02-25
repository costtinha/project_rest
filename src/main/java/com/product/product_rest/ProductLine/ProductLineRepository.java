package com.product.product_rest.ProductLine;

import com.product.product_rest.Product.ProductResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductLineRepository extends JpaRepository<ProductLine,Integer> {
    List<ProductLine> findProductLineByImage(@Param("image") String image);
}
