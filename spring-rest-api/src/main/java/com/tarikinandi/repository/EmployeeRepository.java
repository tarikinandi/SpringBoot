package com.tarikinandi.repository;

import com.tarikinandi.model.Employee;
import com.tarikinandi.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployees() {

        return employeeList;
    }

    public Employee getEmployeeById(int id){
        return employeeList.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
    }

    public List<Employee> getEmployeeWithParams(String firstName , String lastName){
        if(firstName == null && lastName == null){
            return employeeList;
        }
        else if(firstName != null && lastName == null){
            return employeeList.stream().filter(employee -> employee.getFirstName().equals(firstName)).toList();
        }
        else if(firstName == null && lastName != null){
            return employeeList.stream().filter(employee -> employee.getLastName().equals(lastName)).toList();
        }
        else{
            return employeeList.stream().filter(employee -> employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)).toList();
        }
    }

    public Employee saveEmployee(Employee newEmployee){
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployee(int id){
        return employeeList.removeIf(employee -> employee.getId() == id);
    }

    private Employee findEmployeeById(int id){
        Employee findEmployee = null;
        for(Employee emp : employeeList){
            if(emp.getId() == id){
                findEmployee = emp;
                break;
            }
        }
        return findEmployee;
    }

    public Employee updateEmployee(int id , UpdateEmployeeRequest request){
        Employee staff = findEmployeeById(id);
        if (staff != null){
            deleteEmployee(id);
        }

        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(id);
        updatedEmployee.setFirstName(request.getFirstName());
        updatedEmployee.setLastName(request.getLastName());
        employeeList.add(updatedEmployee);
        return updatedEmployee;
    }
}
