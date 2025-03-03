package com.product.product_rest.ProductLine;

import com.product.product_rest.Cache.ProductLineCacheRepository;
import com.product.product_rest.Persistance.ProductLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductLineService {
    private final ProductLineRepository repository;
    private final ProductLineMapper mapper;
    private final ProductLineCacheRepository cacheRepository;

    public ProductLineService(ProductLineRepository repository,
                              ProductLineMapper mapper, ProductLineCacheRepository cacheRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.cacheRepository = cacheRepository;
    }

    public List<ProductLineResponseDto> findProductLine(){
        return repository.findAll()
                .stream()
                .map(mapper::toProductLineResponseDto)
                .collect(Collectors.toList());
    }
    public ProductLineResponseDto saveProductLine(ProductLineDto dto){
        ProductLine pl = mapper.toProductLine(dto);
        pl = repository.save(pl);
        ProductLineCache cache = mapper.toProductLineCache(pl);
        cacheRepository.save(cache);
        return mapper.toProductLineResponseDto(pl);
    }

    public ProductLineResponseDto findProductLineById(int id){

        ProductLineCache cache = cacheRepository.findById(id).orElse(null);
        if(cache != null){
            System.out.println("Encontrado pelo cache!");
            return mapper.cacheToProductLineResponseDto(cache);
        }
        ProductLine db = repository.findById(id).orElse(null);
        if (db != null){
            cacheRepository.save(mapper.toProductLineCache(db));
            System.out.println("Salvo no cache");
            return mapper.toProductLineResponseDto(db);
        }
        return null;

        // return mapper.toProductLineResponseDto(repository.findById(id).orElse(null));
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
