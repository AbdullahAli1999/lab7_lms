package com.example.lab7_lms.Service;

import com.example.lab7_lms.Model.Course;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course> courses = new ArrayList<>();

    //GET
    public ArrayList<Course> getCourses() {
        return courses;
    }

    //ADD
    public boolean addCourse(Course course) {
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            if(c.getCourseId() == course.getCourseId()) {
                return false;
            }

        }
        courses.add(course);
        return true;
    }

    //UPDATE
    public boolean updateCourse(int id,Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseId() == id) {
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }

    //DELETE
    public boolean deleteCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseId() == id) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }

    public Course searchCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getCourseId() == id) {
                return courses.get(i);
            }
        }
        return null;

    }

    public ArrayList<Course> searchByTitle(String name) {
        ArrayList<Course> courses1 = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getTitle().equalsIgnoreCase(name)) {
                courses1.add(courses.get(i));
            }
        }
        return courses1;
    }

    public ArrayList<Course> searchByDate(LocalDate date) {
        ArrayList<Course> courses1 = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getEnrollDate().equals(date)) {
                courses1.add(courses.get(i));
            }
        }
        return courses1;
    }




}
