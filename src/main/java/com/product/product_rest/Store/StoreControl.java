package com.product.product_rest.Store;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreControl {
    public StoreService service;

    public StoreControl(StoreService service) {
        this.service = service;
    }

    @GetMapping()
    public List<StoreDto> findStore(){
        return service.findStore();
    }

    @PostMapping()
    public StoreDto saveStore(
            @Valid @RequestBody StoreDto dto
    ){
        return service.saveStore(dto);
    }

    @GetMapping("/{store-id}")
    public StoreDto findStoreById(
            @PathVariable("store-id") int id
    ){
        return service.findStoreById(id);
    }
    @GetMapping("/store-name/{store-name-var}")
    public List<StoreDto> findStoreByName(
            @PathVariable("store-name-var") String StoreName
    ){
        return service.findStoreByName(StoreName);
    }

    @GetMapping("/storeTotal")
    public List<Store> findStoreTotal(){
        return service.findStoreTotal();
    }

    @DeleteMapping("/{store-id}")
    public void deleteStoreById(
            @PathVariable("store-id") int id
    ){
         service.deleteStoreById(id);
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
