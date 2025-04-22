package com.tarikinandi.service.impl;

import com.tarikinandi.dto.DepartmentDTO;
import com.tarikinandi.dto.EmployeeDTO;
import com.tarikinandi.exception.BaseException;
import com.tarikinandi.exception.ErrorMessage;
import com.tarikinandi.exception.MessageType;
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
        if (optional.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST , id.toString()));
        }
        Employee employee = optional.get();
        Department department = employee.getDepartment();
        BeanUtils.copyProperties(employee, employeeDTO);
        BeanUtils.copyProperties(department, departmentDTO);
        employeeDTO.setDepartment(departmentDTO);
        return employeeDTO;
    }
}
