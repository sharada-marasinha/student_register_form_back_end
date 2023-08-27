package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository repository;
    private ModelMapper mapper;

    @Bean
    public void setup() {
        this.mapper = new ModelMapper();
    }

    @Override
    public void setStudent(Student student) {
        repository.save(this.mapper.map(student, StudentEntity.class));
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> studentList = new ArrayList<>();
        Iterator<StudentEntity> iterator = repository.findAll().iterator();

        iterator.forEachRemaining(studentEntity -> {
            studentList.add(mapper.map(studentEntity, Student.class));
        });

        return studentList;

    }

    @Override
    public Iterable<StudentEntity> getStudentByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

}
