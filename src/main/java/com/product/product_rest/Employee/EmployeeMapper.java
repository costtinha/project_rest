package com.product.product_rest.Employee;

import com.product.product_rest.Office.Office;
import com.product.product_rest.Office.OfficeRepository;
import com.product.product_rest.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

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

}
