package com.ty.scms.dao;

import com.ty.scms.model.Student;

import java.util.List;

public interface StudentDao {

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);

    List<Student> getAllStudents();
}