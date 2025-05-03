package com.tarikinandi.service;

import com.tarikinandi.dto.EmployeeDTO;
import com.tarikinandi.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    Page<Employee> findAllPageable(Pageable pageable);

    List<EmployeeDTO> toListDTO(List<Employee> employeeList );
}
