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
public class CustomerControl {
    private final CustomerService service;

    public CustomerControl(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/customer")
    public List<PaymentResponseDto> findCustomer(){
        return service.findCustomer();
    }

    @PostMapping("/customer")
    public PaymentResponseDto saveCustomer(
           @Valid @RequestBody CustomerDto dto
    ){
        return service.saveCustomer(dto);
    }

    @GetMapping("/customer/{customer-id}")
    public PaymentResponseDto findCustomerById(
            @PathVariable("customer-id") int id
    ){
        return service.findCustomerById(id);
    }

    @GetMapping("/customerTotal")
    public List<Customer> findCustomerTotal(){
        return service.findCustomerTotal();
    }
    @DeleteMapping("/customer/{customer-id}")
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
