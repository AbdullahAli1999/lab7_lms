package com.example.lab7_lms.Controller;

import com.example.lab7_lms.Api.ApiResponse;
import com.example.lab7_lms.Model.Course;
import com.example.lab7_lms.Service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/stu")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    //GET
    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        ArrayList<Course> courses = courseService.getCourses();
        return ResponseEntity.ok(courses);
    }
    //ADD
    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course , Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMessage);
        }
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully added course"));
    }

    //UPDATE
    @PutMapping("update/{id}")
    public ResponseEntity updateCourse(@PathVariable int id, @RequestBody @Valid Course course , Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.badRequest().body(errorMessage);

        }
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully updated course"));

    }
    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully deleted course"));
    }

    //Search by id
    @GetMapping("/search/{id}")
    public ResponseEntity searchCourseById(@PathVariable int id) {
        Course courses = courseService.searchCourse(id);
        if (courses == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
        }
        return ResponseEntity.status(200).body(courses);
    }

    //SEARCH BY TITLE
    @GetMapping("/title/{name}")
    public ResponseEntity searchCourseByTitle(@PathVariable String name) {
        ArrayList<Course> courses = courseService.searchByTitle(name);
        if (courses == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Course not found"));
        }
        return ResponseEntity.status(200).body(courses);

    }
    @GetMapping("/date/{date}")
    public ResponseEntity searchByDate(@PathVariable LocalDate date) {
        ArrayList<Course> courses = courseService.searchByDate(date);
        if (courses == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Course not found"));

        }
        return ResponseEntity.status(200).body(courses);
    }



}
