package com.tarikinandi.controller.impl;

import com.tarikinandi.controller.EmployeeController;
import com.tarikinandi.dto.EmployeeDTO;
import com.tarikinandi.model.RootEntity;
import com.tarikinandi.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/employee")
public class EmployeeControllerImpl extends BaseControllerImpl implements EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/list/{id}")
    @Override
    public RootEntity<EmployeeDTO> findEmployeeById(@PathVariable(value = "id") Long id) {
            return ok(employeeService.findEmployeeById(id));
    }
}
