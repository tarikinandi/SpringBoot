package com.tarikinandi.controller;

import com.tarikinandi.model.Employee;
import com.tarikinandi.model.UpdateEmployeeRequest;
import com.tarikinandi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployees() {
       return   employeeService.getAllEmployees();
    }

    @GetMapping(path = "/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id" , required = true) int id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(path = "/with-params")
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName" , required = false) String name
    , @RequestParam(name = "lastName" , required = false) String lastName){
        System.out.println(name + " " + lastName);
        return employeeService.getEmployeeWithParams(name , lastName);
    }

    @PostMapping("/save-employee")
    public Employee saveEmployee(@RequestBody Employee newEmployee){
        return employeeService.saveEmployee(newEmployee);
    }

    @DeleteMapping("/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id" , required = true) int id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/update-employee/{id}")
    public Employee updateEmployee(@PathVariable(name = "id" , required = true) int id , @RequestBody UpdateEmployeeRequest request){
        return employeeService.updateEmployee(id , request);
    }
}

