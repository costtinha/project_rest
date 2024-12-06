package com.product.product_rest.Order_Product;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class OrderProductControl {
    private final OrderProductService service;

    public OrderProductControl(OrderProductService service) {
        this.service = service;
    }

    @GetMapping("/order_product")
    public List<OrderProductResponseDto> findOrderProduct(){
        return service.findOrderProduct();
    }

    @PostMapping("/order_product")
    public OrderProductResponseDto saveOrderProduct(
            @Valid @RequestBody OrderProductDto dto
    ){
        return service.saveOrderProduct(dto);
    }

    @GetMapping("/order_product/{op-id}/{product-code}")
    public OrderProductResponseDto findOrderProductById(
            @PathVariable("op-id") int orderId,
            @PathVariable("product-code") int productCode

    ){
        return service.findOrderProductById(orderId, productCode);
    }

    @GetMapping("/order_productTotal")
    public List<Order_Product> findOrderProductTotal(){
        return service.findOrderProductTotal();
    }

    @DeleteMapping("/order_product/{op-id}/{product-code}")
    public void deleteOrderProductById(
            @PathVariable("op-id") int orderId,
            @PathVariable("product-id") int productId
    ){
         service.deleteOrderProductById(orderId,productId);
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
