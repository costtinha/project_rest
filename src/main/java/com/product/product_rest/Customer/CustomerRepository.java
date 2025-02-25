package com.product.product_rest.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findCustomerByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
    List<Customer> findCustomerByState(String state);
    List<Customer> findCustomerByCity(String city);
}
