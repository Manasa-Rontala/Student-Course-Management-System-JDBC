package com.ty.scms.main;

import com.ty.scms.dao.EnrollmentDao;
import com.ty.scms.daoimpl.EnrollmentDaoImpl;
import com.ty.scms.model.Enrollment;

import java.util.List;

public class TestEnrollmentDao {

    public static void main(String[] args) {

        EnrollmentDao dao = new EnrollmentDaoImpl();

        // Add
        Enrollment enrollment =
                new Enrollment(301, 101, 201, null);

        dao.addEnrollment(enrollment);


        // Update grade
        dao.updateGrade(301, "A");


        // Fetch
        List<Enrollment> enrollments =
                dao.getEnrollmentsByStudent(101);

        for (Enrollment e : enrollments) {
            System.out.println(e);
        }


        // Delete
        // dao.deleteEnrollment(301);
    }
}