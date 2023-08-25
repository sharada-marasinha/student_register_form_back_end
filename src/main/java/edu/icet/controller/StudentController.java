package edu.icet.controller;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping
    public void setStudents(@RequestBody Student student) {
        studentService.setStudent(student);
    }
    @GetMapping
    public Iterable<StudentEntity> getAllStudent(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{firstName}")
    public Iterable<StudentEntity> getStudentByFirstName(@PathVariable String firstName){
        return studentService.getStudentByFirstName(firstName);
    }
}
