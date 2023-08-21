package edu.icet.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
