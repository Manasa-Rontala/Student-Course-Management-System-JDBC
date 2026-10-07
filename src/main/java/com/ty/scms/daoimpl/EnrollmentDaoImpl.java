package com.ty.scms.daoimpl;

import com.ty.scms.dao.EnrollmentDao;
import com.ty.scms.model.Enrollment;
import com.ty.scms.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDaoImpl implements EnrollmentDao {

    @Override
    public void addEnrollment(Enrollment enrollment) {

        String sql =
                "INSERT INTO enrollments(id, student_id, course_id, grade) " +
                        "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, enrollment.getId());
            pstmt.setInt(2, enrollment.getStudentId());
            pstmt.setInt(3, enrollment.getCourseId());

            // Grade is initially NULL
            pstmt.setNull(4, Types.VARCHAR);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Enrollment added successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void updateGrade(int enrollmentId, String grade) {

        String sql =
                "UPDATE enrollments SET grade = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, grade);
            pstmt.setInt(2, enrollmentId);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Grade updated successfully");
            } else {
                System.out.println("Enrollment not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteEnrollment(int id) {

        String sql =
                "DELETE FROM enrollments WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Enrollment deleted successfully");
            } else {
                System.out.println("Enrollment not found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Enrollment> getEnrollmentsByStudent(int studentId) {

        String sql =
                "SELECT * FROM enrollments WHERE student_id = ?";

        List<Enrollment> enrollments = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, studentId);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {

                    Enrollment enrollment = new Enrollment();

                    enrollment.setId(rs.getInt("id"));
                    enrollment.setStudentId(rs.getInt("student_id"));
                    enrollment.setCourseId(rs.getInt("course_id"));
                    enrollment.setGrade(rs.getString("grade"));

                    enrollments.add(enrollment);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return enrollments;
    }
}