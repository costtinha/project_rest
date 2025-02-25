package com.product.product_rest.ProductLine;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductLineService {
    private final ProductLineRepository repository;
    private final ProductLineMapper mapper;

    public ProductLineService(ProductLineRepository repository,
                              ProductLineMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ProductLineResponseDto> findProductLine(){
        return repository.findAll()
                .stream()
                .map(mapper::toProductLineResponseDto)
                .collect(Collectors.toList());
    }
    public ProductLineResponseDto saveProductLine(ProductLineDto dto){
        return mapper.toProductLineResponseDto(repository.save(mapper.toProductLine(dto)));
    }

    public ProductLineResponseDto findProductLineById(int id){
        return mapper.toProductLineResponseDto(repository.findById(id).orElse(null));
    }

    public List<ProductLine> findProductLineTotal(){
        return repository.findAll();
    }

    public void deleteProductLineById(int id){
            repository.deleteById(id);
    }


    public List<ProductLineResponseDto> findProductLineByImage(String image) {
        return repository.findProductLineByImage(image)
                .stream()
                .map(mapper::toProductLineResponseDto)
                .collect(Collectors.toList());
    }
}
