package com.tarikinandi.service.impl;

import com.tarikinandi.DTO.DepartmentDTO;
import com.tarikinandi.DTO.EmployeeDTO;
import com.tarikinandi.model.Department;
import com.tarikinandi.model.Employee;
import com.tarikinandi.repository.EmployeeRepository;
import com.tarikinandi.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO findEmployeeById(Long id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        DepartmentDTO departmentDTO = new DepartmentDTO();

        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }
        Employee employee = optional.get();
        Department department = employee.getDepartment();
        BeanUtils.copyProperties(employee, employeeDTO);
        BeanUtils.copyProperties(department, departmentDTO);

        employeeDTO.setDepartment(departmentDTO);
        return employeeDTO;
    }
}
