package com.product.product_rest.ProductLine;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ProductLineControl {
    private final ProductLineService service;

    public ProductLineControl(ProductLineService service) {
        this.service = service;
    }

    @GetMapping("/productLine")
    public List<ProductLineResponseDto> findProductLine(){
        return service.findProductLine();
    }
    @PostMapping("/productLine")
    public ProductLineResponseDto saveProductLine(
            @Valid @RequestBody ProductLineDto dto
    ){
        return service.saveProductLine(dto);
    }

    @GetMapping("/productLine/{pl-id}")
    public ProductLineResponseDto findProductLineById(
            @PathVariable("pl-id") int id
    ){
        return service.findProductLineById(id);
    }

    @GetMapping("/productLineTotal")
    public List<ProductLine> findProductLineTotal(){
        return service.findProductLineTotal();
    }

    @DeleteMapping("/productLine/{pl-id}")
    public void deleteProductLineById(
            @PathVariable("pl-id") int id
    ){
         service.deleteProductLineById(id);
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
