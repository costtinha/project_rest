package com.product.product_rest.Product;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ProductContro {
    private final ProductService service;

    public ProductContro(ProductService service) {
        this.service = service;
    }

    @GetMapping("/product")
    public List<ProductResponseDto> findProduct(){
        return service.findProduct();
    }
    @PostMapping("/product")
    public ProductResponseDto saveProduct(
            @Valid @RequestBody ProductDto dto
    ){
        return service.saveProduct(dto);
    }

    @GetMapping("/product/{p-id}")
    public ProductResponseDto findProductById(
            @PathVariable("p-id") int id
    ){
        return service.findProductById(id);
    }

    @GetMapping("/productTotal")
    public List<Product> findProductTotal(){
        return service.findProductTotal();
    }

    @DeleteMapping("/product/{p-id}")
    public void deleteProductById(
            @PathVariable("p-id") int id
    ){
        service.deleteProductById(id);
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
