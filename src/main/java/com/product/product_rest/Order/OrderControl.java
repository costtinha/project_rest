package com.product.product_rest.Order;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderControl {
    private final OrderService service;

    public OrderControl(OrderService service) {
        this.service = service;
    }
    @GetMapping()
    public List<OrderResponseDto> findOrder(){
        return service.findOrder();
    }

    @PostMapping()
    public OrderResponseDto saveOrder(
            @Valid @RequestBody OrderDto dto
    ){
        return service.saveOrder(dto);
    }

    @GetMapping("/{order-id}")
    public OrderResponseDto findOrderById(
            @PathVariable("order-id") int id
    ){
        return service.findOrderById(id);
    }

    @GetMapping("/orderTotal")
    public List<Order> findOrderTotal(){
        return service.findOrderTotal();
    }

    @GetMapping("/status/{status-var}")
    public List<OrderResponseDto> findOrderByStatus(
            @PathVariable("status-var") int status
    ){
        return service.findOrderByStatus(status);
    }

    @DeleteMapping("/{order-id}")
    public void deleteOrderById(
            @PathVariable("order-id") int id
    ){
        service.deleteOrderById(id);
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
