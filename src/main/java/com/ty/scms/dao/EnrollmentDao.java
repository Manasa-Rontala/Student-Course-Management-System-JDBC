package com.ty.scms.dao;

import com.ty.scms.model.Enrollment;

import java.util.List;

public interface EnrollmentDao {

    void addEnrollment(Enrollment enrollment);

    void updateGrade(int enrollmentId, String grade);

    void deleteEnrollment(int id);

    List<Enrollment> getEnrollmentsByStudent(int studentId);
}