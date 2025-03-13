package com.example.lab7_lms.Service;

import com.example.lab7_lms.Model.Course;
import com.example.lab7_lms.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students = new ArrayList<>();

    //GET
    public ArrayList<Student> getStudents() {
        return students;
    }

    //ADD
    public boolean addStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getStudentId() == student.getStudentId()) {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    //UPDATE
    public boolean updateStudent(int id,Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == id) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    //DELETE
    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == id) {
                return students.get(i);

            }
        }
        return null;
    }

    public Student knowSupervisor(String supervisor) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getSupervisor().equals(supervisor)) {
                return s;
            }
        }
        return null;
    }

    public Student rangeGpa(double min, double max) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getGpa() >= min && s.getGpa() <= max) {
                return s;
            }
        }
        return null;
    }

    public boolean graduate(int totalHour) {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).totalHour > 120){
                students.get(i).setGraduate(true);
                return true;
            }
        }
        return false;
    }



}
