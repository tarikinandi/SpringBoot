package com.tarikinandi.service;

import com.tarikinandi.DTO.EmployeeDTO;

public interface IEmployeeService {

    EmployeeDTO findEmployeeById(Long id);
}
