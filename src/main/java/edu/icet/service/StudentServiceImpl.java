package edu.icet.service;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository repository;
    private ModelMapper mapper;

    @Bean
    public void setup() {
        this.mapper = new ModelMapper();
    }

    @Override
    public void setStudent(Student student, MultipartFile file) throws IOException {
        final String folderPath = "C:/Users/shara/OneDrive/Desktop/Student_Registation_Form-EE/FrontEnd/profile/";
        String filePath = folderPath + file.getOriginalFilename();
        StudentEntity entity = mapper.map(student, StudentEntity.class);
        entity.setImageName(file.getOriginalFilename());
        entity.setImagePath(filePath);
        repository.save(entity);
        file.transferTo(new File(filePath));
    }

    @Override
    public boolean updateStudent(Long id, Student student) {
        if (repository.existsById(id)) {
            repository.save(mapper.map(student, StudentEntity.class));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteStudent(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> studentList = new ArrayList<>();
        Iterator<StudentEntity> iterator = repository.findAll().iterator();

        while (iterator.hasNext()) {
            studentList.add(mapper.map(iterator.next(), Student.class));
        }
        return studentList;

    }

    @Override
    public Student getStudentById(Long id) {
        ArrayList<Student> studentList = new ArrayList<>();
        Iterator<StudentEntity> iterator = repository.findById(id).stream().iterator();
        if (repository.existsById(id)) {

            while (iterator.hasNext()) {
                studentList.add(mapper.map(iterator.next(), Student.class));
            }
            return studentList.get(0);

        } else {
            return null;
        }
    }

    @Override
    public Iterable<StudentEntity> getStudentByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }
}




