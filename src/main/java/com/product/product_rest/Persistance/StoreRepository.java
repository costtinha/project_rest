package com.product.product_rest.Persistance;

import com.product.product_rest.Store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store,Integer> {
    List<Store> findStoreByName(String StoreName);
}
