package com.product.product_rest.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findEmployeeByJobTitle(String JobTitle);
    Employee findEmployeeByEmail(String email);
}
