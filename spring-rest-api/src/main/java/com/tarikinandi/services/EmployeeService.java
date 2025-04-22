package com.tarikinandi.services;

import com.tarikinandi.model.Employee;
import com.tarikinandi.model.UpdateEmployeeRequest;
import com.tarikinandi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(int id){
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParams(String firstName , String lastName){
        return employeeRepository.getEmployeeWithParams(firstName , lastName);
    }

    public Employee saveEmployee(Employee newEmployee){
        return employeeRepository.saveEmployee(newEmployee);
    }

    public boolean deleteEmployee(int id){
        return employeeRepository.deleteEmployee(id);
    }

    public Employee updateEmployee(int id , UpdateEmployeeRequest request){
        return employeeRepository.updateEmployee(id , request);
    }
}
