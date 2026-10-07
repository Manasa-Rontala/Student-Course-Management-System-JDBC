package com.ty.scms.main;

import com.ty.scms.util.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ProcedureExample {

    public static void main(String[] args) {

        String sql = "CALL assign_grade(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             CallableStatement cstmt = con.prepareCall(sql)) {

            cstmt.setInt(1, 101);
            cstmt.setInt(2, 201);
            cstmt.setString(3, "A");

            cstmt.execute();

            System.out.println("Grade assigned successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}