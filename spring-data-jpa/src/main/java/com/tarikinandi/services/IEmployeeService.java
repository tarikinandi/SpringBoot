package com.tarikinandi.services;

import com.tarikinandi.dto.DepartmentDTO;
import com.tarikinandi.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {

    public List<EmployeeDTO> findAllEmployees();

}
