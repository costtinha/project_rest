package com.product.product_rest.Customer;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerControl {
    private final CustomerService service;

    public CustomerControl(CustomerService service) {
        this.service = service;
    }

    @GetMapping()
    public List<CustomerResponseDto> findCustomer(){
        return service.findCustomer();
    }

    @PostMapping()
    public CustomerResponseDto saveCustomer(
           @Valid @RequestBody CustomerDto dto
    ){
        return service.saveCustomer(dto);
    }

    @GetMapping("/{customer-id}")
    public CustomerResponseDto findCustomerById(
            @PathVariable("customer-id") int id
    ){
        return service.findCustomerById(id);
    }

    @GetMapping("/customerTotal")
    public List<Customer> findCustomerTotal(){
        return service.findCustomerTotal();
    }
    @GetMapping("/name/{first-name}/{last-name}")
    public List<CustomerResponseDto> findCustomerByFullName(
            @PathVariable("first-name") String FirstName,
            @PathVariable("last-name") String LastName
    ){
        return service.findCustomerByFullName(FirstName,LastName);
    }
    @GetMapping("/state/{state}")
    public List<CustomerResponseDto> findCustomersByState(
            @PathVariable("state") String state
    ){
        return service.findCustomerByState(state);
    }

    @GetMapping("/city/{city}")
    public List<CustomerResponseDto> findCustomersByCity(
            @PathVariable("city") String city
    ){
        return service.findCustomersByCity(city);
    }

    @DeleteMapping("/{customer-id}")
    public void deleteCustomerById(
            @PathVariable("customer-id") int id
    ){
        service.deleteCustomerById(id);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String,String>();
        exp.getBindingResult()
                .getAllErrors()
                .forEach(error ->{
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
