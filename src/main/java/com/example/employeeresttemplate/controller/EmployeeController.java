package com.example.employeeresttemplate.controller;

import com.example.employeeresttemplate.entity.Employee;
import com.example.employeeresttemplate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/api", params = "theAge")
    public ResponseEntity<List<Employee>> getEmployeeLargerThan(@RequestParam int theAge) {
        return new ResponseEntity<>(employeeService.findEmployeesLagerThan(theAge), HttpStatus.OK);
    }

    @GetMapping("/api")
    public ResponseEntity<Map<Integer,List<Employee>>> getAllEmployeeByAge(){
        try{
            return new ResponseEntity<>(employeeService.groupEmployeeByAge(),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        return new ResponseEntity("This is 404 response", HttpStatus.NOT_FOUND);
    }
}
