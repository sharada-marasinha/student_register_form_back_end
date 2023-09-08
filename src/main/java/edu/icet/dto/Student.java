package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private long id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private String mobileNumber;
    private String gender;
    private String address;
    private String city;
    private String pinCode;
    private String state;
    private String country;
    private String hobbies;
    private String otherHobby;
    private String classX;
    private String classXII;
    private String graduation;
    private String masters;
    private String selectedCourse;
    private String imageName;
    private String imagePath;
}
