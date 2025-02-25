package com.product.product_rest.Customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

     public List<CustomerResponseDto> findCustomer(){
        return repository.findAll()
                .stream()
                .map(mapper::toCustomerResponseDto)
                .collect(Collectors.toList());
     }

     public CustomerResponseDto saveCustomer(CustomerDto dto){
        return mapper.toCustomerResponseDto(repository.save(mapper.toCustomer(dto)));
     }

     public CustomerResponseDto findCustomerById(int id){
        return mapper.toCustomerResponseDto(repository.findById(id).orElse(null));
     }

     public List<Customer> findCustomerTotal(){
        return repository.findAll();
     }

     public void deleteCustomerById(int id){
        repository.deleteById(id);
     }


    public List<CustomerResponseDto> findCustomerByFullName(String firstName, String lastName)
    {
        return repository.findCustomerByName(firstName,lastName)
                .stream()
                .map(mapper::toCustomerResponseDto)
                .collect(Collectors.toList());
    }

    public List<CustomerResponseDto> findCustomerByState(String state) {
        return repository.findCustomerByState(state)
                .stream()
                .map(mapper::toCustomerResponseDto)
                .collect(Collectors.toList());
    }

    public List<CustomerResponseDto> findCustomersByCity(String city) {
        return repository.findCustomerByCity(city)
                .stream()
                .map(mapper::toCustomerResponseDto)
                .collect(Collectors.toList());
    }
}
