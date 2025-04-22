package com.tarikinandi.services.impl;

import com.tarikinandi.dto.DepartmentDTO;
import com.tarikinandi.dto.EmployeeDTO;
import com.tarikinandi.entities.Department;
import com.tarikinandi.entities.Employee;
import com.tarikinandi.repository.EmployeeRepository;
import com.tarikinandi.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();
        if(employees.size() > 0){
            for(Employee employee : employees){
                EmployeeDTO employeeDTO = new EmployeeDTO();
                BeanUtils.copyProperties(employee, employeeDTO);

                employeeDTO.setDepartment(new DepartmentDTO(employee.getDepartment().getId() , employee.getDepartment().getName()));
                employeeDTOList.add(employeeDTO);
            }
        }
        return employeeDTOList;
    }

}
