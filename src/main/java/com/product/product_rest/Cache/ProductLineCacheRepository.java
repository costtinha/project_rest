package com.product.product_rest.Cache;

import com.product.product_rest.ProductLine.ProductLineCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ProductLineRedisRepository")
public interface ProductLineCacheRepository extends CrudRepository<ProductLineCache,Integer> {

}
