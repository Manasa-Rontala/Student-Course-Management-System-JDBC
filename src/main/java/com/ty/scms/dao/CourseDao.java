package com.ty.scms.dao;

import com.ty.scms.model.Course;

import java.util.List;

public interface CourseDao {

    void addCourse(Course course);

    void updateCourse(Course course);

    void deleteCourse(int id);

    List<Course> getAllCourses();
}