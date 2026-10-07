package com.ty.scms.main;

import com.ty.scms.util.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FunctionExample {

    public static void main(String[] args) {

        String sql = "SELECT get_student_avg(?)";

        try (Connection con = DBConnection.getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, 101);

            try (ResultSet rs = cstmt.executeQuery()) {

                if (rs.next()) {
                    double averageGpa = rs.getDouble(1);

                    System.out.println("Student ID : 101");
                    System.out.println("Average GPA: " + averageGpa);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}