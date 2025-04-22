package com.tarikinandi.controller.impl;

import com.tarikinandi.controller.IEmployeeController;
import com.tarikinandi.dto.EmployeeDTO;
import com.tarikinandi.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/list")
    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

}
