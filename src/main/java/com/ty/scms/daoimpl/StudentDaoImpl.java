package com.ty.scms.daoimpl;

import com.ty.scms.dao.StudentDao;
import com.ty.scms.model.Student;
import com.ty.scms.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void addStudent(Student student) {

        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO students(id,name,email,dob) VALUES(?,?,?,?)";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getEmail());
            pstmt.setDate(4, new java.sql.Date(student.getDob().getTime()));

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student added successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void updateStudent(Student student) {

        String sql = "UPDATE students SET name = ?, email = ?, dob = ? WHERE id = ?";

        Connection con = DBConnection.getConnection();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setDate(3, new java.sql.Date(student.getDob().getTime()));
            pstmt.setInt(4, student.getId());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        Connection con = DBConnection.getConnection();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Student> getAllStudents() {

        String sql = "SELECT * FROM students";

        Connection con = DBConnection.getConnection();

        List<Student> students = new ArrayList<>();

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDob(rs.getDate("dob"));

                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }
}