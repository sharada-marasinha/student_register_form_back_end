package edu.icet.controller;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{firstName}")
    public Iterable<StudentEntity> getStudentByFirstName(@PathVariable String firstName){
        return studentService.getStudentByFirstName(firstName);
    }
    @GetMapping("std-id/{id}")
    public Student getStudentByFirstName(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        boolean updated = studentService.updateStudent(id, student);
        if (updated) {
            return ResponseEntity.ok("Student updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
