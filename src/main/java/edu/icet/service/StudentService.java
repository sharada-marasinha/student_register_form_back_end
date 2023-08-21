package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;

public interface StudentService {
    void setStudent(Student student);
    Iterable<StudentEntity> getAllStudents();
}
