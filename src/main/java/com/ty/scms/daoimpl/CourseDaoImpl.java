package com.ty.scms.daoimpl;

import com.ty.scms.dao.CourseDao;
import com.ty.scms.model.Course;
import com.ty.scms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public void addCourse(Course course) {

        String sql = "INSERT INTO courses(id,name,credits) VALUES(?,?,?)";

        Connection con = DBConnection.getConnection();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, course.getId());
            pstmt.setString(2, course.getName());
            pstmt.setInt(3, course.getCredits());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Course added successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void updateCourse(Course course) {

        String sql = "UPDATE courses SET name = ?, credits = ? WHERE id = ?";

        Connection con = DBConnection.getConnection();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, course.getName());
            pstmt.setInt(2, course.getCredits());
            pstmt.setInt(3, course.getId());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Course updated successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteCourse(int id) {

        String sql = "DELETE FROM courses WHERE id = ?";

        Connection con = DBConnection.getConnection();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Course deleted successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Course> getAllCourses() {

        String sql = "SELECT * FROM courses";

        Connection con = DBConnection.getConnection();

        List<Course> courses = new ArrayList<>();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Course course = new Course();

                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setCredits(rs.getInt("credits"));

                courses.add(course);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courses;
    }
}