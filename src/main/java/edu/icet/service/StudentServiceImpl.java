package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository repository;
    private ModelMapper mapper;

    StudentServiceImpl() {
        setup();
    }

    public void setup() {
        this.mapper = new ModelMapper();
    }

    @Override
    public void setStudent(Student student) {
        StudentEntity entity = this.mapper.map(student, StudentEntity.class);
        repository.save(entity);
    }

    @Override
    public Iterable<StudentEntity> getAllStudents() {
        return repository.findAll();
    }

}
