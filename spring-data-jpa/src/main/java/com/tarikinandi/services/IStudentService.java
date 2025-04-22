package com.tarikinandi.services;

import com.tarikinandi.dto.StudentDTO;
import com.tarikinandi.dto.StudentDTOIU;
import com.tarikinandi.entities.Student;

import java.util.List;

public interface IStudentService {

    public StudentDTO saveStudent(StudentDTOIU student);

    public List<StudentDTO> getAllStudents();

    public StudentDTO getStudentById(int id);

    public void deleteStudentById(int id);

    public StudentDTO updateStudent(int id , StudentDTOIU studentDTOIU);
}
