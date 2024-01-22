package edu.icet.controller;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    //-----------------------------------Add Student----------------------------------->>
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void setStudents(@ModelAttribute Student student, @RequestPart("file") MultipartFile file) throws IOException {
        studentService.setStudent(student, file);
    }
    //----------------------------------Update Student-------------------------------->>
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@ModelAttribute Student student, @PathVariable Long id, @RequestPart("file") MultipartFile file) throws IOException {
        return studentService.updateStudent(id, student, file)?
            ResponseEntity.ok("Student updated successfully"):
            ResponseEntity.notFound().build();
    }
    //----------------------------------Delete Student--------------------------------->>
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
       return studentService.deleteStudent(id)?
               ResponseEntity.ok("Student deleted successfully"):
               ResponseEntity.notFound().build();
    }
    //---------------------------------Get All Student--------------------------------->>
    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }
    //------------------------------Get Student By First Name-------------------------->>
    @GetMapping("/{firstName}")
    public Iterable<StudentEntity> getStudentByFirstName(@PathVariable String firstName) {
        return studentService.getStudentByFirstName(firstName);
    }
    //---------------------------------Get Student By id------------------------------->>
    @GetMapping("std-id/{id}")
    public Student getStudentByFirstName(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}
