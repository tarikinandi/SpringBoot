package com.tarikinandi.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private long id;
    private String name;
    private DepartmentDTO department;
}
