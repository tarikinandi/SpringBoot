package com.tarikinandi.config;

import com.tarikinandi.model.Employee;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1 , "Tarık" , "Inandı"));
        employeeList.add(new Employee(2 , "Enes" , "Inandı"));
        employeeList.add(new Employee(3 , "Mahmut" , "Tuncer"));
        employeeList.add(new Employee(4 , "Berra" , "Inandı"));
        employeeList.add(new Employee(5 , "Nurcan" , "Inandı"));
        employeeList.add(new Employee(6 , "Levent" , "Inandı"));

        return employeeList;
    }
}
