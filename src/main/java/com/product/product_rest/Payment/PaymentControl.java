package com.product.product_rest.Payment;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentControl {

    private final PaymentService service;

    public PaymentControl(PaymentService service) {
        this.service = service;
    }

    @GetMapping()
    public List<PaymentResponseDto> findPayment(){
        return service.findPayment();
    }

    @PostMapping()
    public PaymentResponseDto savePayment(
           @Valid @RequestBody PaymentDto dto
    ){
        return service.savePayment(dto);
    }

    @GetMapping("/{payment-checkNum}")
    public PaymentResponseDto findPaymentById(
            @PathVariable("payment-CheckNum") String CheckNum
    ){
        return service.findPaymentByCheckNum(CheckNum);
    }

    @GetMapping("/customer/{customer-id}")
    public List<PaymentResponseDto> findPaymentByCustomer(
            @PathVariable("customer-id") int customerId
    ){
        return service.findPaymentByCustomer(customerId);
    }

    @GetMapping("/paymentTotal")
    public List<Payment> findPaymentTotal(){
        return service.findPaymentTotal();
    }
    @DeleteMapping("/{payment-checkNum}")
    public void deleteByCheckNum(
            @PathVariable("payment-checkNum") String ck
    ){
        service.deleteByCheckNum(ck);
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
