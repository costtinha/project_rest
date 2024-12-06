package com.product.product_rest.Product;

import com.product.product_rest.ProductLine.ProductLine;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductDto dto){
        ProductLine pl = new ProductLine();
        pl.setId(dto.productLine_id());
        return new Product(pl,
                dto.name(),
                dto.vendor(),
                dto.pdtDescription(),
                dto.qntyInStock(),
                dto.buyPrice(), dto.MSRP());
    }


    public ProductResponseDto toProductResponseDto(Product product){
        return new ProductResponseDto(product.getName(),
                product.getQntyInStock(),
                product.getBuyPrice());
    }
}
