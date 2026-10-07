package com.ty.scms.main;

import com.ty.scms.dao.CourseDao;
import com.ty.scms.daoimpl.CourseDaoImpl;
import com.ty.scms.model.Course;

import java.util.List;

public class TestCourseDao {

    public static void main(String[] args) {

        CourseDao dao = new CourseDaoImpl();


        // ADD
        Course course = new Course(
                201,
                "Java Programming",
                4
        );

        dao.addCourse(course);


        // UPDATE
        Course updatedCourse = new Course(
                201,
                "Advanced Java Programming",
                5
        );

        dao.updateCourse(updatedCourse);


        // FETCH ALL
        List<Course> courses = dao.getAllCourses();

        for (Course c : courses) {
            System.out.println(c);
        }


        // DELETE
        // dao.deleteCourse(201);
    }
}