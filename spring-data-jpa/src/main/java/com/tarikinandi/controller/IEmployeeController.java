package com.tarikinandi.controller;

import com.tarikinandi.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeController {

    public List<EmployeeDTO> findAllEmployees();

}
