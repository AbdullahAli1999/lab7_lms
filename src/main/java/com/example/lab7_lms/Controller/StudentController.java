package com.example.lab7_lms.Controller;

import com.example.lab7_lms.Api.ApiResponse;
import com.example.lab7_lms.Model.Student;
import com.example.lab7_lms.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/stuu")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    //GET
    @GetMapping("/get")
    public ResponseEntity getStudents() {
        ArrayList<Student> students = studentService.getStudents();
        return ResponseEntity.ok(students);
    }
    //ADD
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(errorMessage));
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully added student"));
    }
    //UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @RequestBody @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(errorMessage));
        }
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully updated student"));

    }

    //DELETE
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully deleted student"));
    }

    //SearchById

    @GetMapping("/search/{id}")
    public ResponseEntity searchStu(@PathVariable int id) {
        Student student = studentService.searchStudent(id);
        if (student == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Student not found"));

        }
        return ResponseEntity.status(200).body(new ApiResponse("Successfully searched student"));
    }


//Know Supervisor
    @GetMapping("/supervisor/{supervisor}")
    public ResponseEntity knowSupervisor(@PathVariable String supervisor) {
        ArrayList<Student> students = studentService.getStudents();
        Student student = studentService.knowSupervisor(supervisor);
        if (student == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
        }
        students.add(student);
        return ResponseEntity.status(200).body(students);
    }

    //RANGE GPA
    @GetMapping("/range/{min}/{max}")
    public ResponseEntity rangeGpa(@PathVariable double min, @PathVariable double max) {
        ArrayList<Student> students = studentService.getStudents();
        Student student = studentService.rangeGpa(min, max);
        if (student == null) {
            return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
        }
        students.add(student);
        return ResponseEntity.status(200).body(students);
    }

    @PutMapping("/graduate/{totalHour}")
    public ResponseEntity isGraduate(@PathVariable int totalHour) {
        //ArrayList<Student> students = studentService.getStudents();
      boolean graduate = studentService.graduate(totalHour);
        if (!graduate) {
            return ResponseEntity.status(400).body(new ApiResponse("Student not found"));
        }

        return ResponseEntity.status(200).body("students updated");

    }




}
