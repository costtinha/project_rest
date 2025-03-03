package com.product.product_rest.Cache;

import com.product.product_rest.Office.Office;
import com.product.product_rest.Office.OfficeCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("officeRedisRepository")
public interface OfficeCacheRepository extends CrudRepository<OfficeCache,Integer> {
}
