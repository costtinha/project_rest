package com.product.product_rest.Employee;

import com.product.product_rest.Cache.EmployeeCacheRepository;
import com.product.product_rest.Persistance.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final  EmployeeMapper mapper;
    private final EmployeeCacheRepository cacheRepository;

    public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper, EmployeeCacheRepository cacheRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.cacheRepository = cacheRepository;
    }

    public List<EmployeeResponseDto> findEmployee(){
        return repository.findAll()
                .stream()
                .map(mapper::toEmployeeResponseDto)
                .collect(Collectors.toList());
    }

    public EmployeeResponseDto saveEmployee(EmployeeDto dto){
        Employee employee = mapper.toEmployee(dto);
        employee = repository.save(employee);
        EmployeeCache cache = mapper.toEmployeeCache(employee);
        cacheRepository.save(cache);
        return mapper.toEmployeeResponseDto(employee);

        //return mapper.toEmployeeResponseDto(repository.save(mapper.toEmployee(dto)));
    }

    public EmployeeResponseDto findEmployeeById(int id){
        EmployeeCache cache = cacheRepository.findById(id).orElse(null);
        if (cache != null){
            System.out.println("Encontrado pelo cache");
            return mapper.cacheToEmployeeResponseDto(cache);
        }
        Employee db = repository.findById(id).orElse(null);
        if (db != null){
            cacheRepository.save(mapper.toEmployeeCache(db));
            System.out.println("Salvo no cache");
            return mapper.toEmployeeResponseDto(db);
        }
        return null;


        //return mapper.toEmployeeResponseDto(repository.findById(id).orElse(null));
    }
    public List<Employee> findEmployeeTotal() {
        return repository.findAll();
    }

    public void deleteEmployeeById(int id){
            repository.deleteById(id);
    }


    public List<EmployeeResponseDto> findEmployeeByJobTitle(String jobTitle) {
        return repository.findEmployeeByJobTitle(jobTitle)
                .stream()
                .map(mapper::toEmployeeResponseDto)
                .collect(Collectors.toList());
    }

    public EmployeeResponseDto findEmployeeByEmail(String email) {
        return mapper.toEmployeeResponseDto(repository.findEmployeeByEmail(email));
    }
}
