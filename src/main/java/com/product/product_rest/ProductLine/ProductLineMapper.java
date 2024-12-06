package com.product.product_rest.ProductLine;

import org.springframework.stereotype.Service;

@Service
public class ProductLineMapper {
    public ProductLine toProductLine(ProductLineDto dto){
        return new ProductLine(dto.descInText(), dto.descInHTML(), dto.image());
    }

    public ProductLineResponseDto toProductLineResponseDto(ProductLine pl){
        return new ProductLineResponseDto(pl.getDescInText(), pl.getImage());
    }
}
