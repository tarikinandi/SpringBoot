package com.tarikinandi.controller.impl;

import com.tarikinandi.controller.IStudentController;
import com.tarikinandi.dto.StudentDTO;
import com.tarikinandi.dto.StudentDTOIU;
import com.tarikinandi.entities.Student;
import com.tarikinandi.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class    StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping(path = "/save")
    @Override
    public StudentDTO saveStudent(@RequestBody @Valid StudentDTOIU student) {
        return studentService.saveStudent(student);
    }

    @GetMapping(path = "/list")
    @Override
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public StudentDTO getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudentById(@PathVariable int id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public StudentDTO updateStudent(@PathVariable(name = "id") int id , @RequestBody @Valid StudentDTOIU updateStudent) {
        return studentService.updateStudent(id , updateStudent);
    }
}
