package com.ty.scms.main;

import com.ty.scms.dao.StudentDao;
import com.ty.scms.daoimpl.StudentDaoImpl;
import com.ty.scms.model.Student;

import java.util.Date;
import java.util.List;

public class TestStudentDao {

    public static void main(String[] args) {

        StudentDao dao = new StudentDaoImpl();


        // ADD
        Student student = new Student(
                102,
                "Rahul",
                "rahul@gmail.com",
                new Date()
        );

        dao.addStudent(student);


        // UPDATE
        Student updatedStudent = new Student(
                102,
                "Rahul Kumar",
                "rahulkumar@gmail.com",
                new Date()
        );

        dao.updateStudent(updatedStudent);


        // FETCH ALL
        List<Student> students = dao.getAllStudents();

        for (Student s : students) {
            System.out.println(s);
        }


        // DELETE
        dao.deleteStudent(102);
    }
}