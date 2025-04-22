package com.tarikinandi.controller;

import com.tarikinandi.dto.EmployeeDTO;
import com.tarikinandi.model.RootEntity;


public interface EmployeeController {
    public RootEntity<EmployeeDTO> findEmployeeById(Long id);
}
