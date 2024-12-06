package com.product.product_rest.Store;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {
    private final StoreRepository repository;
    private final StoreMappers mappers;

    public StoreService(StoreRepository repository, StoreMappers mappers) {
        this.repository = repository;
        this.mappers = mappers;
    }

    public List<StoreDto> findStore(){
        return repository.findAll()
                .stream()
                .map(mappers::toStoreDto)
                .collect(Collectors.toList());
    }

    public StoreDto saveStore(StoreDto dto){
        return mappers.toStoreDto(repository.save(mappers.toStore(dto)));
    }


    public StoreDto findStoreById(int id){
        return mappers.toStoreDto(repository.findById(id)
                .orElse(null));
    }

    public List<Store> findStoreTotal(){
        return repository.findAll();
    }

    public void deleteStoreById(int id){
        repository.deleteById(id);
    }







}

