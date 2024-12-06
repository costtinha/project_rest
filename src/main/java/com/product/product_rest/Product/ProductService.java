package com.product.product_rest.Product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ProductResponseDto> findProduct(){
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponseDto)
                .collect(Collectors.toList());
    }

    public ProductResponseDto saveProduct(ProductDto dto){
        return mapper.toProductResponseDto(repository.save(mapper.toProduct(dto)));
    }

    public ProductResponseDto findProductById(int id){
        return mapper.toProductResponseDto(repository.findById(id).orElse(null));
    }

    public List<Product> findProductTotal(){
        return repository.findAll();
    }

    public void deleteProductById(int id){
        repository.deleteById(id);
    }

}
