package com.product.product_rest.Persistance;

import com.product.product_rest.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("EmployeeJpaRepository")
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findEmployeeByJobTitle(String JobTitle);
    Employee findEmployeeByEmail(String email);
}
