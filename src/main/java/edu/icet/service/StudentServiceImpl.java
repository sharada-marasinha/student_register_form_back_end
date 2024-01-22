package edu.icet.service;

import edu.icet.annotations.MethodStat;
import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private ModelMapper mapper;

    @Bean
    public void setup() {
        this.mapper = new ModelMapper();
    }

    private static final String URL = "C:/Users/shara/OneDrive/Desktop/Student_Registation_Form-EE/FrontEnd/profile/";

    //------------------------------------Add Student----------------------------------->>
    @Override
    @MethodStat
    public void setStudent(Student student, MultipartFile file) throws IOException {
        String filePath = URL + file.getOriginalFilename();
        StudentEntity entity = mapper.map(student, StudentEntity.class);
        entity.setImageName(file.getOriginalFilename());
        entity.setImagePath(filePath);
        repository.save(entity);
        file.transferTo(new File(filePath));
    }

    //-----------------------------------Update Student-------------------------------->>
    @Override
    @MethodStat
    public boolean updateStudent(Long id, Student student, MultipartFile file) throws IOException {
        if (repository.findById(id).isPresent()) {
            StudentEntity entity = mapper.map(student, StudentEntity.class);
            String filePath = URL + file.getOriginalFilename();
            entity.setImageName(file.getOriginalFilename());
            entity.setImagePath(filePath);
            repository.save(entity);
            file.transferTo(new File(filePath));
            return true;
        } else {
            return false;
        }
    }
    //-----------------------------------Delete Student--------------------------------->>
    @Override
    @MethodStat
    public boolean deleteStudent(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    //-----------------------------------Get All Student--------------------------------->>


    @Override
    @MethodStat
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        for (StudentEntity studentEntity : repository.findAll()) {
            studentList.add(mapper.map(studentEntity, Student.class));
        }


        return studentList;

    }

    //---------------------------------Get Student By ID--------------------------------->>
    @Override
    @MethodStat
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

    //---------------------------------Get Student By First Name-------------------------->>
    @Override
    @MethodStat
    public Iterable<StudentEntity> getStudentByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }
}




