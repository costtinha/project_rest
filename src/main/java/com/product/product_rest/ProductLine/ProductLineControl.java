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
@RequestMapping("/productLine")
public class ProductLineControl {
    private final ProductLineService service;

    public ProductLineControl(ProductLineService service) {
        this.service = service;
    }

    @GetMapping()
    public List<ProductLineResponseDto> findProductLine(){
        return service.findProductLine();
    }
    @PostMapping()
    public ProductLineResponseDto saveProductLine(
            @Valid @RequestBody ProductLineDto dto
    ){
        return service.saveProductLine(dto);
    }

    @GetMapping("/{pl-id}")
    public ProductLineResponseDto findProductLineById(
            @PathVariable("pl-id") int id
    ){
        return service.findProductLineById(id);
    }
    @GetMapping("/image/{image-var}")
    public List<ProductLineResponseDto> findProductLineByImage(
            @PathVariable("image-var") String image
    ){
        return service.findProductLineByImage(image);
    }

    @GetMapping("/productLineTotal")
    public List<ProductLine> findProductLineTotal(){
        return service.findProductLineTotal();
    }

    @DeleteMapping("/{pl-id}")
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
