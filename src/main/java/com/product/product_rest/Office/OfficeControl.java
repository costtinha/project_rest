package com.product.product_rest.Office;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class OfficeControl {
    private final OfficeService service;

    public OfficeControl(OfficeService service) {
        this.service = service;
    }

    @GetMapping("/office")
    public List<OfficeResponseDto> findOffice(){
        return service.findOffice();
    }

    @PostMapping("/office")
    public OfficeResponseDto save(
            @Valid @RequestBody OfficeDto dto
    ){
        return service.saveOffice(dto);
    }

    @GetMapping("/office/{office-id}")
    public OfficeResponseDto findById(
            @PathVariable("office-id") int id){
        return service.findById(id);
    }

    @GetMapping("/officeTotal")
    public List<Office> findOfficeTotal(){
        return service.findOfficeTotal();
    }

    @DeleteMapping("/office/{office-id}")
    public void DeleteOffice(
            @PathVariable("office-id") int id
    ){
        service.deleteOffice(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String,String>();
        exp.getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }





}
