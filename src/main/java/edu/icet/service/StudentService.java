package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;

import java.util.ArrayList;
import java.util.List;

public interface StudentService {
    void setStudent(Student student);
    List<Student> getAllStudents();

    Iterable<StudentEntity> getStudentByFirstName(String firstName);
}
