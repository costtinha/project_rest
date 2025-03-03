package com.product.product_rest.Persistance;

import com.product.product_rest.Shippers.Shippers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippersRepository extends JpaRepository<Shippers,Integer> {
    List<Shippers> findShippersByCompanyName(String companyName);
}
