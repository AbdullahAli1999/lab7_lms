package com.example.lab7_lms.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Course {
    @NotNull(message = "Can not be null please!")
    @Positive(message = "Must be positive number")
    @Min(value = 2 , message = "More than Two numbers")
    private int courseId;
    @NotEmpty(message = "Can not be EMPTY!!")
    @Size(min = 1,max = 14, message = "The name Can not be less than 1 ")
    private String title;
    @NotEmpty(message = "Can not be EMPTY!!")
    @Size(min = 3,max = 14, message = "The name Can not be less than 3 ")
    private String instructor;
    @Min(value = 1, message = "Credits must be at least 1")
    @Max(value = 10, message = "Credits cannot be more than 10")
    private int credits;
    @NotNull(message = "Enroll date cannot be null")
    @PastOrPresent(message = "Enroll date must be today or in the past")
    private LocalDate enrollDate;

}
