package com.tarikinandi.controller.impl;

import com.tarikinandi.DTO.EmployeeDTO;
import com.tarikinandi.controller.IEmployeeController;
import com.tarikinandi.service.IEmployeeService;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeControllerImpl implements IEmployeeController {

    private final IEmployeeService employeeService;

    // Constructor Injection (Modern Best Practice)
    public EmployeeControllerImpl(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    @GetMapping("/{id}")
    public EmployeeDTO findEmployeeById(@PathVariable @NotNull Long id) {
        return employeeService.findEmployeeById(id);
    }
}
