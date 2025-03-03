package com.product.product_rest.ProductLine;

import com.product.product_rest.Product.Product;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class ProductLineMapper {
    public ProductLine toProductLine(ProductLineDto dto){
        return new ProductLine(dto.descInText(), dto.descInHTML(), dto.image());
    }

    public ProductLineResponseDto toProductLineResponseDto(ProductLine pl){
        return new ProductLineResponseDto(pl.getDescInText(), pl.getImage());
    }
    public ProductLineCache toProductLineCache(ProductLine productLine){
        ProductLineCache cache = new ProductLineCache();
        cache.setId(productLine.getId());
        cache.setDescInText(productLine.getDescInText());
        cache.setDescInHTML(productLine.getDescInHTML());
        cache.setImage(productLine.getImage());
        cache.setProductsCode(productLine.getProducts() != null ?
                productLine.getProducts()
                        .stream()
                        .map(Product::getCode)
                        .collect(Collectors.toList())
                        : Collections.emptyList());

        return cache;
    }
    public ProductLineResponseDto cacheToProductLineResponseDto(ProductLineCache cache){
        ProductLineResponseDto dto = new ProductLineResponseDto(
                cache.getDescInText(),
                cache.getImage()
        );
        return dto;
    }
}
