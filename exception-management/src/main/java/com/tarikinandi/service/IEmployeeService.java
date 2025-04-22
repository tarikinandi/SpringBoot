package com.tarikinandi.service;

import com.tarikinandi.dto.EmployeeDTO;
import com.tarikinandi.model.Employee;

public interface IEmployeeService {

    public EmployeeDTO findEmployeeById(Long id);
}
