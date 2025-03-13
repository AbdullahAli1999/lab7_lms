package com.example.lab7_lms.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "Student ID Can not be null please!")
    @Positive(message = "Must be positive number(SID)")
    @Min(value = 2 , message = "More than Two numbers(SID)")
    private int studentId;
    @NotEmpty(message = "The Name Can not be EMPTY!!")
    @Size(min = 3,max = 14, message = "The name Can not be less than 3 (NAME)")
    private String name;
    @Email
    private String email;
    @NotEmpty(message = "Phone number cannot be empty.")
    @Pattern(regexp = "^05\\d{8}$", message = "Phone number must start with '05' and be exactly 10 digits long.")
    private String phone;
    @NotNull(message = "GPA can not be null!")
    @Min(value = 0, message = "GPA cannot be less than 0")
    @Max(value = 5, message = "GPA cannot be more than 5")
    private double gpa;
    @NotEmpty(message = "Gender can not be empty!!")
    @Pattern(regexp = "Male|Female", message = "Gender must be 'Male' or 'Female'")
    private String gender;
    @NotEmpty(message = "The supervisor can not be empty!")
    @Pattern(regexp = "Abdullah|ahmad", message = "Supervisor must be either  'Abdullah' or 'Ahmad'")
    private String supervisor;
    @Min(3)
    @Max(144)
    public int totalHour;
    private boolean graduate = false;



}
