package com.product.product_rest.Employee;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeControl {
    private final EmployeeService service;

    public EmployeeControl(EmployeeService service) {
        this.service = service;
    }

    @GetMapping()
    public List<EmployeeResponseDto> findEmployee(){
        return service.findEmployee();
    }

    @PostMapping()
    public EmployeeResponseDto saveEmployee(
            @Valid @RequestBody EmployeeDto dto
    ){
        return service.saveEmployee(dto);
    }

    @GetMapping("/{employee-id}")
    public EmployeeResponseDto findEmployeeById(
            @PathVariable("employee-id") int id
    ){
        return service.findEmployeeById(id);
    }

    @GetMapping("/employeeTotal")
    public List<Employee> findEmployeeTotal(){
        return service.findEmployeeTotal();
    }

    @GetMapping("/jobtitle/{job-title}")
    public List<EmployeeResponseDto> findEmployeeByJobTitle(
            @PathVariable("job-title") String JobTitle
    ){
        return service.findEmployeeByJobTitle(JobTitle);
    }

    @GetMapping("/employee-email/{email}")
    public EmployeeResponseDto findEmployeeByEmail(
            @PathVariable("email") String email
    ){
        return service.findEmployeeByEmail(email);
    }


    @DeleteMapping("/{employee-id}")
    public void deleteEmployeeById(
            @PathVariable("employee-id") int id
    ){
        service.deleteEmployeeById(id);
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
