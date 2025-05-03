package com.tarikinandi.service.impl;

import com.tarikinandi.dto.DepartmentDTO;
import com.tarikinandi.dto.EmployeeDTO;
import com.tarikinandi.model.Employee;
import com.tarikinandi.repository.EmployeeRepository;
import com.tarikinandi.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAllPageable(Pageable pageable) {

        Page<Employee> page = employeeRepository.findAllPageable(pageable);
        return page;
    }

    @Override
    public List<EmployeeDTO> toListDTO(List<Employee> employeeList) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for(Employee employee : employeeList){
            EmployeeDTO dto = new EmployeeDTO();
            DepartmentDTO department = new DepartmentDTO();

            BeanUtils.copyProperties(employee , dto);
            BeanUtils.copyProperties(employee.getDepartment() , department);
            dto.setDepartment(department);
            employeeDTOList.add(dto);
        }

        return employeeDTOList;
    }
}
