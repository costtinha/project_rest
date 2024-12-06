package com.product.product_rest.Shippers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ShippersControl {

    private final ShippersService service;

    public ShippersControl(ShippersService service) {
        this.service = service;
    }

    @GetMapping("/shippers")
    public List<ShippersDto> findShippers() {
        return service.findShippers();
    }

    @PostMapping("/shippers")
    public ShippersDto saveShippers(
            @Valid @RequestBody ShippersDto dto
    ) {
        return service.saveShippers(dto);
    }

    @GetMapping("/shippers/{shippers-id}")
    public ShippersDto findShipperById(
            @PathVariable("shippers-id") int id
    ) {
        return service.findShippersById(id);
    }

    @GetMapping("/shippersTotal")
    public List<Shippers> findShippersTotal() {
        return service.findShippersTotal();
    }

    @DeleteMapping("/shippers/{shippers-id}")
    public void deleteShippersById(
            @PathVariable("shippers-id") int id
    ) {
        service.deleteShippersById(id);
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
