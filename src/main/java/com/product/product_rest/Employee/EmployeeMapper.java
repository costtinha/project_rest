package com.product.product_rest.Employee;

import com.product.product_rest.Customer.Customer;
import com.product.product_rest.Office.Office;
import com.product.product_rest.Persistance.OfficeRepository;
import com.product.product_rest.Persistance.EmployeeRepository;
import com.product.product_rest.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class EmployeeMapper {
    private final OfficeRepository officeRepository;
    private final EmployeeRepository employeeRepository;

    public EmployeeMapper(OfficeRepository officeRepository, EmployeeRepository employeeRepository) {
        this.officeRepository = officeRepository;
        this.employeeRepository = employeeRepository;
    }

    public Employee toEmployee(EmployeeDto dto){
        Office office = officeRepository.findById(dto.OfficeCode())
                .orElseThrow(() -> new ResourceNotFoundException("Office not found with id " + dto.OfficeCode()));

        Employee supervisor = null;
        if (dto.reportsTo() != 0) {
            supervisor = employeeRepository.findById(dto.reportsTo())
                    .orElseThrow(() -> new ResourceNotFoundException("Supervisor not found with id " + dto.reportsTo()));
        }

        Employee employee = new Employee(
                office,
                supervisor,
                dto.lastName(),
                dto.firstName(),
                dto.extension(),
                dto.email(),
                dto.jobTitle()
        );
        return employee;

    }

    public EmployeeResponseDto toEmployeeResponseDto(Employee employee){
        return new EmployeeResponseDto(
                employee.getOfficeCode().getCode(),
                employee.getLastName(),
                employee.getFirstName(),
                employee.getEmail(),
                employee.getJobTitle());
    }

    public EmployeeCache toEmployeeCache(Employee employee){
        EmployeeCache cache = new EmployeeCache();
        cache.setEmployeeId(employee.getEmployeeId());
        cache.setOfficeCode(employee.getOfficeCode());
        cache.setLastName(employee.getLastName());
        cache.setFirstName(employee.getFirstName());
        cache.setExtension(employee.getExtension());
        cache.setEmail(employee.getEmail());
        cache.setJobTitle(employee.getJobTitle());
        cache.setEmployees(employee.getEmployees() != null ?
                employee.getEmployees()
                        .stream()
                        .map(Employee::getEmployeeId)
                        .collect(Collectors.toList())
                        : Collections.emptyList()
                );
        cache.setCustomers(employee.getCustomers() != null ?
                employee.getCustomers()
                        .stream()
                        .map(Customer::getId)
                        .collect(Collectors.toList())
                        : Collections.emptyList());
        return cache;

    }
    public EmployeeResponseDto cacheToEmployeeResponseDto(EmployeeCache cache){
        EmployeeResponseDto dto = new EmployeeResponseDto(cache.getOfficeCode().getCode(),
                cache.getLastName(),
                cache.getFirstName(),
                cache.getEmail(),
                cache.getJobTitle());
        return dto;

    }

}
