package com.product.product_rest.Store;

import org.springframework.stereotype.Service;

@Service
public class StoreMappers {

    public Store toStore(StoreDto dto){
        return new Store(dto.storeName());
    }
    public StoreDto toStoreDto(Store store){
        return new StoreDto(store.getStoreName());
    }
}
