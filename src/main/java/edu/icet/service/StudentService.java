package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    void setStudent(Student student, MultipartFile file) throws IOException;
    List<Student> getAllStudents();

    Iterable<StudentEntity> getStudentByFirstName(String firstName);

    boolean updateStudent(Long id, Student student, MultipartFile file) throws IOException;

    boolean deleteStudent(Long id);


    Student getStudentById(Long id);
}
