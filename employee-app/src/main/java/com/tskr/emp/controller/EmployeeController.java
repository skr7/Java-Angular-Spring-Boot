package com.tskr.emp.controller;


import com.tskr.emp.entity.Employee;
import com.tskr.emp.repository.EmployeeRepository;
import com.tskr.emp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins ="http://localhost:4200")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        log.info("EmployeeController.getAllEmployees()");
        return service.getAllEmployees();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        log.info("EmployeeController.addEmployee()");
        return service.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeByEmpId(@PathVariable("id") int empId){
        log.info("EmployeeController.addEmployee()");
        Employee employee=service.getEmployeeByEmpId(empId);
        return ResponseEntity.ok(employee);
    }


   @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") int empId){
       log.info("EmployeeController.updateEmployee()");
       Employee updatedEmployee =service.updateEmployee(employee,empId);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployeeByEmpId(@PathVariable("id") int empId){
        service.deleteEmployee(empId);
        log.info("Employee deleted with Successfully");
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }





}
