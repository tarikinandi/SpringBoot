package com.tarikinandi.exceptionmanagement;

import com.tarikinandi.dto.EmployeeDTO;
import com.tarikinandi.service.IEmployeeService;
import com.tarikinandi.starter.ExceptionManagementApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {ExceptionManagementApplication.class})
class ExceptionManagementApplicationTests {

    @Autowired
    private IEmployeeService employeeService;

    @BeforeEach
    public void BeforeEach(){
        System.out.println("Before each çalıştı");
    }

    @AfterEach
    public void AfterEach(){
        System.out.println("After each çalıştı");
    }

    @Test
    public void testFindEmployeeById() {
        EmployeeDTO employee = employeeService.findEmployeeById(3L);
        assertEquals(3L, employee.getId());
        assertNotNull(employee.getDepartment());
    }

}
