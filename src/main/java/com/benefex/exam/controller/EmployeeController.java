package com.benefex.exam.controller;

import com.benefex.exam.CustomException;
import com.benefex.exam.model.EmployeePojo;
import com.benefex.exam.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeePojo> addEmployee(@RequestBody EmployeePojo employeePojo) throws CustomException {

        return ResponseEntity.ok(employeeService.addEmployee(employeePojo));
    }

    @GetMapping("/employeeDetail")
    public ResponseEntity<EmployeePojo> getEmployeeDetails(@RequestParam Integer employeeNo){
        return ResponseEntity.ok(employeeService.getEmployeeDetail(employeeNo));
    }

    @GetMapping
    public ResponseEntity<List<EmployeePojo>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}
