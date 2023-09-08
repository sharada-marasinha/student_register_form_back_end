package edu.icet.controller;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //Get All Student
    @PostMapping
    public void setStudents(@ModelAttribute Student student, @RequestPart("file") MultipartFile file) throws IOException {
        studentService.setStudent(student,file);
    }
    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }
    //Get Student By First Name
    @GetMapping("/{firstName}")
    public Iterable<StudentEntity> getStudentByFirstName(@PathVariable String firstName){
        return studentService.getStudentByFirstName(firstName);
    }
    //Get Student By id
    @GetMapping("std-id/{id}")
    public Student getStudentByFirstName(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    //Update Student
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        boolean updated = studentService.updateStudent(id, student);
        if (updated) {
            return ResponseEntity.ok("Student updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return ResponseEntity.ok("Student deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //----------------------------------------------------------------------------------------------------
}
