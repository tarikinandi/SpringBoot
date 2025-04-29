package com.tarikinandi.controller;

import com.tarikinandi.DTO.EmployeeDTO;
import jakarta.validation.constraints.NotNull;

public interface IEmployeeController {

    EmployeeDTO findEmployeeById(@NotNull Long id);
}
