package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String firstName;
    private String lastname;
    private String dob;
    private String email;
    private String mobileNumber;
    private String gender;
    private String address;
    private String city;
    private int pinCode;
    private String state;
    private String country;
    private String hobbies;
    private String qualification;
    private String coursesAppliedFor;
}
