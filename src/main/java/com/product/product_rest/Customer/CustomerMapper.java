package com.product.product_rest.Customer;

import com.product.product_rest.Employee.Employee;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerDto dto){
        Employee employee = new Employee();
        employee.setEmployeeId(dto.salesRepEmployeeNum());
        return new Customer(employee, dto.lastName(),
                dto.firstName(), dto.phone(),
                dto.address1(),
                dto.address2(),
                dto.city(),
                dto.state(),
                dto.postalCode(),
                dto.country(),
                dto.creditLimit());
    }

    public CustomerResponseDto toCustomerResponseDto(Customer customer){
            return new CustomerResponseDto(customer.getSalesRepEmployeeNum().getEmployeeId(),
                    customer.getLastName(),
                    customer.getFirstName(),
                    customer.getPhone(),
                    customer.getState(),
                    customer.getCountry());

    }
}
