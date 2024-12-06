package com.product.product_rest.Employee;

import com.product.product_rest.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final  EmployeeMapper mapper;

    public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EmployeeResponseDto> findEmployee(){
        return repository.findAll()
                .stream()
                .map(mapper::toEmployeeResponseDto)
                .collect(Collectors.toList());
    }

    public EmployeeResponseDto saveEmployee(EmployeeDto dto){
        return mapper.toEmployeeResponseDto(repository.save(mapper.toEmployee(dto)));
    }

    public EmployeeResponseDto findEmployeeById(int id){
        return mapper.toEmployeeResponseDto(repository.findById(id).orElse(null));
    }
    public List<Employee> findEmployeeTotal() {
        return repository.findAll();
    }

    public void deleteEmployeeById(int id){
            repository.deleteById(id);
    }




}
