package com.product.product_rest.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficeRepository  extends JpaRepository<Office, Integer> {
    List<Office> findOfficeByCity(String city);
    List<Office> findOfficeByState(String state);
    List<Office> findOfficeByCountry(String country);
}
