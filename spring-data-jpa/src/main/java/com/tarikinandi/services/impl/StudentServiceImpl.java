package com.tarikinandi.services.impl;

import com.tarikinandi.dto.CourseDTO;
import com.tarikinandi.dto.StudentDTO;
import com.tarikinandi.dto.StudentDTOIU;
import com.tarikinandi.entities.Course;
import com.tarikinandi.entities.Student;
import com.tarikinandi.repository.StudentRepository;
import com.tarikinandi.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO saveStudent(StudentDTOIU dtoStudentUI) {
        Student student = new Student();
        StudentDTO response = new StudentDTO();
        BeanUtils.copyProperties(dtoStudentUI , student);

        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent , response);
        return response;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> dtoList = new ArrayList<>();
        List<Student> students = studentRepository.findAllStudents();
        for (Student student : students) {
            StudentDTO dto = new StudentDTO();
            BeanUtils.copyProperties(student , dto);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public StudentDTO getStudentById(int id) {
       StudentDTO studentDTO = new StudentDTO();
       Optional<Student> optional = studentRepository.findById(id);
       if(optional.isEmpty() ){
           return null;
       }
       Student dbStudent = optional.get();
       BeanUtils.copyProperties(dbStudent , studentDTO);

       if(dbStudent.getCourses() != null && !dbStudent.getCourses().isEmpty()) {
           for (Course course : dbStudent.getCourses()){
               CourseDTO courseDTO = new CourseDTO();
               BeanUtils.copyProperties(course , courseDTO);
               studentDTO.getCourses().add(courseDTO);
           }
       }
        return studentDTO;
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO updateStudent(int id, StudentDTOIU studentDTOIU) {
        StudentDTO response = new StudentDTO();
        Optional<Student> optional = studentRepository.findStudentById(id);
        if (optional.isPresent()) {
            Student dbStudent = optional.get();

            dbStudent.setFirstName(studentDTOIU.getFirstName());
            dbStudent.setLastName(studentDTOIU.getLastName());
            dbStudent.setBirthOfDate(studentDTOIU.getBirthOfDate());

            Student updatedStudent = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent , response);
            return response;
        }
        return null;
    }
}
