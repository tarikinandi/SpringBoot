package com.tarikinandi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private int id;

    private  String firstName;

    private  String lastName;

    private List<CourseDTO> courses = new ArrayList<>();
}
