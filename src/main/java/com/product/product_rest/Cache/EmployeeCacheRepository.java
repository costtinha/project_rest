package com.product.product_rest.Cache;

import com.product.product_rest.Employee.EmployeeCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("EmployeeRedisRepository")
public interface EmployeeCacheRepository extends CrudRepository<EmployeeCache,Integer> {
}
